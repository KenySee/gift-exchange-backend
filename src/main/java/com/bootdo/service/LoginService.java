package com.bootdo.service;

import com.bootdo.common.exception.ResponseException;
import com.bootdo.common.utils.DesUtils;
import com.bootdo.common.utils.Qiniu;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.domain.entity.SysUserconnection;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by bozhou on 2017/11/24.
 */
@Service
public class LoginService {

    @Autowired
    SysUserconnectionService sysUserconnectionService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    Qiniu qiniu;
    @Autowired
    SysRoleService sysRoleService;
    @Value("${ROLE_CLIENT_USER}")
    String ROLE_CLIENT_USER;
    @Value("${DEFALUT_PASS}")
    String DEFALUT_PASS;


    /**
     * 第三方登录加注册
     *
     * @param displayName
     * @param imageUrl
     * @param providerUserId
     * @param providerId
     * @param unionid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public SysUser memberOtherLogin(String displayName, String imageUrl, String providerUserId, String providerId, String unionid) {
        //判断用户以前是否第三方登录过
        SysUserconnection sysUserconnection = sysUserconnectionService.getUserconnectionByProviderUserIdAndProviderId(providerUserId, providerId);
        SysUser sysUser = null;
        //以前未绑定，注册新的账号
        if (sysUserconnection == null) {
            sysUser = memberOtherRegister(displayName, imageUrl, providerUserId, providerId);
            sysUserconnection = new SysUserconnection();
            sysUserconnection.setDisplayname(displayName);
            sysUserconnection.setImageurl(imageUrl);
            sysUserconnection.setProviderid(providerId);
            sysUserconnection.setProvideruserid(providerUserId);
            sysUserconnection.setUnionid(unionid);
            sysUserconnection.setUserid(sysUser.getId());
            sysUserconnection.setRank(1);
            sysUserconnectionService.save(sysUserconnection);
        } else {
            sysUser = sysUserService.getUserByUserID(sysUserconnection.getUserid());
        }
        return sysUser;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SysUser memberOtherRegister(String displayName, String imageUrl, String providerUserId, String providerId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserstatus("1");
        sysUser.setRealname(displayName);
        sysUser.setUsername(providerId + "-" + providerUserId);
        sysUser.setUserpassword(new BCryptPasswordEncoder().encode(DEFALUT_PASS));
        try {
            sysUser.setCredentialssalt(new DesUtils().encrypt(DEFALUT_PASS));
        } catch (Exception e) {
            throw new ResponseException("服务器异常", HttpStatus.valueOf(500));
        }
        //将用户头像存放到七牛云
        if (StringUtils.isNotBlank(imageUrl) && !imageUrl.startsWith(qiniu.getHost())) {
            String fileName = UUID.randomUUID().toString();
            qiniu.fetch(imageUrl, fileName);
            String headUrl = String.format("%s/%s", qiniu.getHost(), fileName);
            sysUser.setHeadimage(headUrl);
        }
        sysUserService.saveHyUser(sysUser);
        //保存用户角色
        sysRoleService.insertUserRole(sysUser.getId(), ROLE_CLIENT_USER);
        return sysUser;
    }
}
