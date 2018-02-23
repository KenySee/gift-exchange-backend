package com.bootdo.common.security.controller;

import com.bootdo.common.exception.ResponseException;
import com.bootdo.common.page.AjaxResponse;
import com.bootdo.common.security.JwtAuthenticationRequest;
import com.bootdo.common.security.JwtTokenUtil;
import com.bootdo.common.security.JwtUser;
import com.bootdo.common.security.service.JwtAuthenticationResponse;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.service.SysPermissionService;
import com.bootdo.service.SysUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "JWT相关接口", description = "相关接口相关api", position = 1)
@RestController
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "用户登陆", notes = "用户名密码登录登陆。", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public AjaxResponse<?> createAuthenticationToken(JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
        // Perform the security
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload password post-security so we can generate token
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails, device);
            SysUser sysUser = sysUserService.getUserByUserName(authenticationRequest.getUsername());
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("user", sysUser);
            // Return the token
            return new AjaxResponse<>(map);
        }catch (Exception e){
            throw new ResponseException("用户名或者密码错误！",HttpStatus.UNAUTHORIZED);
        }
    }

    @ApiOperation(value = "用户token刷新", notes = "用户token刷新。", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.POST)
    public AjaxResponse<?> refreshAndGetAuthenticationToken(@ApiParam(value = "用户token", required = true) @RequestParam(required = true) String token) {
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
            JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
            if (jwtTokenUtil.canTokenBeRefreshed(token, user.getSysUser().getLastPasswordResetDate())) {
                String refreshedToken = jwtTokenUtil.refreshToken(token);
                return new AjaxResponse<>(new JwtAuthenticationResponse(refreshedToken));
            } else {
                throw new ResponseException("登录已过期，请重新登录！", HttpStatus.UNAUTHORIZED);
            }
        }catch (Exception e){
            throw new ResponseException("登录已过期，请重新登录！", HttpStatus.UNAUTHORIZED);
        }
    }

    //检测token是否失效
    @ApiOperation(value = "用户token刷新", notes = "用户token刷新。", position = 1)
    @ApiResponses({@ApiResponse(code = 200, message = "运行结果")})
    @RequestMapping(value = "isTokenExpired", method = RequestMethod.POST)
    public AjaxResponse<?> isTokenExpired( @ApiParam(value = "用户token", required = true) @RequestParam(required = true) String token) {
        AjaxResponse response = new AjaxResponse();
        Boolean isExpired = false;
        response.setMessage("Token已过期");
        try {
            isExpired = !jwtTokenUtil.isTokenExpired(token);
            if(isExpired){
                String username = jwtTokenUtil.getUsernameFromToken(token);
                SysUser sysUser = sysPermissionService.fetchUserPermission(username);
                response.setMessage("操作成功");
                response.setResult(sysUser);
            }
        }catch (Exception e){
        }
        response.setSuccess(isExpired);
        return response;
    }
}
