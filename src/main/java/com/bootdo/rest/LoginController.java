package com.bootdo.rest;

import com.bootdo.common.exception.ResponseException;
import com.bootdo.common.page.AjaxResponse;
import com.bootdo.common.utils.DesUtils;
import com.bootdo.common.utils.TokenUtils;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统登陆注册
 * Created by zhoubo on 2016/12/1.
 */
@RestController
@RequestMapping("/sys/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenUtils tokenUtils;


    @RequestMapping(value = "/memberOtherLogin", method = RequestMethod.POST)
    public AjaxResponse memberOtherLogin(
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) String imageUrl,
            @RequestParam String providerUserId,
            @RequestParam String providerId,
            @RequestParam(required = false) String unionid,
            Device device) {
        SysUser sysUser = loginService.memberOtherLogin(displayName, imageUrl, providerUserId, providerId, unionid);
        String token = null;
        try {
            token = tokenUtils.createToken(sysUser.getUsername(), new DesUtils().decrypt(sysUser.getCredentialssalt()), device);
        } catch (Exception e) {

            throw new ResponseException("", HttpStatus.valueOf(500));
        }
        return new AjaxResponse<>(token);
    }

}
