package com.bootdo.common.security.service;

import com.bootdo.common.exception.ResponseException;
import com.bootdo.common.security.JwtUserFactory;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isNotBlank(username)) {
            //根据username查询用户信息
            SysUser sysUser = sysUserService.getUserByUserName(username);
            if(sysUser !=null) {
                return JwtUserFactory.create(sysUser);
            }else{
                throw new ResponseException(String.format("未找到用户'%s'.", username), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } else {
            throw new ResponseException(String.format("未找到用户'%s'.", username),HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
