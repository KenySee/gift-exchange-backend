package com.bootdo.common.social.core.controller;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.common.security.JwtTokenUtil;
import com.bootdo.common.security.service.JwtAuthenticationResponse;
import com.bootdo.common.social.core.support.SocialUserInfo;
import com.bootdo.common.utils.DesUtils;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.domain.entity.SysUserconnection;
import com.bootdo.service.SysUserService;
import com.bootdo.service.SysUserconnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Deament
 * @date 2017/10/1
 **/
@Controller
public class SocialController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserconnectionService sysUserconnectionService;

    @ResponseBody
    @GetMapping("/social/user")
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        SocialUserInfo userInfo = new SocialUserInfo();
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadimg(connection.getImageUrl());
        return userInfo;
    }

    @RequestMapping(value = {"/common/signup"}, method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResponse signup(HttpServletRequest request, String providerId, String providerUserId, Device device) throws Exception {
        // 如果已经绑定， 那就直接登陆吧
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        if (connection != null) {
            ConnectionKey key = connection.getKey();
            SysUserconnection sysUserconnection = sysUserconnectionService.getUserconnectionByProviderUserIdAndProviderId(key.getProviderUserId(), key.getProviderId());
            SysUser sysUser = sysUserService.getUserByUserID(sysUserconnection.getUserid());
            if (sysUser != null) {
                // Perform the security
                final Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                sysUser.getUsername(),
                                new DesUtils().decrypt(sysUser.getUserpassword())
                        )
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // Reload password post-security so we can generate token
                final UserDetails userDetails = userDetailsService.loadUserByUsername("admin");
                final String token = jwtTokenUtil.generateToken(userDetails, device);
                //插入数据库
//                providerSignInUtils.doPostSignUp(sysUser.getId(), new ServletWebRequest(request));
                // Return the token
                return new AjaxResponse<>(new JwtAuthenticationResponse(token));
            }
        }
        return null;
    }

//	/** 第三方 登陆注册新用户绑定方式**/
//	@PostMapping(value = { "/common/thirdPart/register", "/signup" })
//	public AjaxResponse register(UserVO user, HttpServletRequest request,
//                       @RequestParam(name = "email", required = true) String email,
//                       @RequestParam(name = VrifyCodeUtil.PARAMETERNAME, required = true) String vrifyCode, HttpSession session)
//			throws Exception {
//		Json j = new Json();
//		j.setMsg("操作成功");
//		j.setSuccess(true);
//		Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
//		if (connection.getKey().getProviderId() == null) {
//			j.setMsg("操作失败，请返回主页从新操作！");
//			j.setSuccess(false);
//			return j;
//			// 会话失效 或者是被攻击
//		}
//		// 不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
//		if (!VrifyCodeUtil.checkvrifyCode(vrifyCode, session)) {
//			j.setSuccess(true);
//			j.setMsg("验证码不正确！");
//			return j;
//		}
//		j.setSuccess(true);
//		j.setMsg("我们将发送邮箱到您的邮箱中进行验证，大约3小时左右不验证将删除注册信息");
//		String now = DateUtil.getDateTime();
//		user.setCredentialssalt(new DesUtils().encrypt(user.getPassword()));
//		user.setPassword(RbacConstant.getpwd(user.getPassword()));
//		user.setRoleid("10");
//		user.setPhone("");
//		user.setState(UserStateConstant.DIE);
//		user.setCreatetime(now);
//		try {
//			userService.save(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//			j.setMsg("创建失败，已存在该用户");
//			return j;
//		}
//		String url = SystemConstant.getSystemdomain() + "/common/login_do/relife.do?userid=" + user.getId()
//				+ "&username=" + user.getUsername() + "&salt=" + user.getCredentialssalt();
//		// 获取激活邮件的hmtl内容
//		String contemt = this.getActiveContent(url, user.getUsername());
//		try {
//			SendEmailInter send = new SendQqmailImpl();
//			send.sendMail(email, SystemConstant.getSystemName() + "注册", contemt);
//		} catch (Exception e) {
//			e.printStackTrace();
//			BaseMap<String, Object> wheremap = new BaseMap<String, Object>();
//			wheremap.put("id", user.getId());
//			userService.remove(wheremap);
//			j.setMsg("发送邮箱失败，可能被提供方拦截，再试一次或者换一种邮箱类型");
//			return j;
//		}
//		providerSignInUtils.doPostSignUp("userid", new ServletWebRequest(request));
//		return null;
//	}
//
//	/** 第三方 账号绑定**/
//	@ResponseBody
//	@PostMapping("/common/thirdpart/bind")
//	public Json bind(HttpServletRequest httpServletRequest, ModelMap map) throws Exception {
//		Json j = new Json();
//		j.setMsg("操作成功");
//		j.setSuccess(true);
//		// 首先检测验证码
//		if (!VrifyCodeUtil.checkvrifyCode(httpServletRequest, map)) {
//			j.setMsg("验证码错误");
//			j.setSuccess(false);
//			return j;
//		}
//		Connection<?> connection = providerSignInUtils
//				.getConnectionFromSession(new ServletWebRequest(httpServletRequest));
//		if (connection != null) {
//			if (connection.getKey().getProviderId() == null) {
//				j.setMsg("操作失败，请返回主页从新操作！");
//				j.setSuccess(false);
//				return j;
//				// 会话失效 或者是被攻击
//			}
//		} else {
//			return othertype(httpServletRequest);
//		}
//
//		String username = ServletUtil.getStringParamDefaultBlank(httpServletRequest, "username");
//		String password = ServletUtil.getStringParamDefaultBlank(httpServletRequest, "password");
//		Loginproxy proxy = LoginProxyController.login(httpServletRequest, username, password, null);
//		if (proxy.isSuccess()) {
//			SocialUserInfo userInfo = new SocialUserInfo();
//			userInfo.setProviderId(connection.getKey().getProviderId());
//			userInfo.setProviderUserId(connection.getKey().getProviderUserId());
//			userInfo.setNickname(connection.getDisplayName());
//			userInfo.setHeadimg(connection.getImageUrl());
//			providerSignInUtils.doPostSignUp(proxy.getUser().getId(), new ServletWebRequest(httpServletRequest));
//
//			j.setMsg("绑定成功");
//			j.setSuccess(true);
//			return j;
//		} else {
//			j.setMsg(proxy.getResult());
//			j.setSuccess(false);
//			return j;
//		}
//	}
//
//	/** 非正规渠道绑定。 **/
//	private Json othertype(HttpServletRequest httpServletRequest) throws AuthenticationException, Exception {
//		Json j = new Json();
//		String providerId = httpServletRequest.getSession().getAttribute("ProviderSignInAttempt").toString();
//		String providerUserId = httpServletRequest.getSession().getAttribute("providerUserId").toString();
//		String username = ServletUtil.getStringParamDefaultBlank(httpServletRequest, "username");
//		String password = ServletUtil.getStringParamDefaultBlank(httpServletRequest, "password");
//		Loginproxy proxy = LoginProxyController.login(httpServletRequest, username, password, null);
//		if (proxy.isSuccess()) {
//			SocialUserInfo userInfo = new SocialUserInfo();
//			userInfo.setProviderId(providerId);
//			userInfo.setProviderUserId(providerUserId);
//			userInfo.setNickname("");
//			userInfo.setHeadimg("");
//		//	providerSignInUtils.doPostSignUp(proxy.getUser().getId(), new ServletWebRequest(httpServletRequest));
//			socialUserService.create(proxy.getUser().getId(), providerUserId, providerId);
//			httpServletRequest.getSession().removeAttribute("ProviderSignInAttempt");
//			httpServletRequest.getSession().removeAttribute("providerUserId");
//			j.setMsg("绑定成功");
//			j.setSuccess(true);
//			return j;
//		} else {
//			j.setMsg(proxy.getResult());
//			j.setSuccess(false);
//			return j;
//		}
//	}
}
