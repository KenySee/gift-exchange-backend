package com.bootdo.rest;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.example.SysUserExample;
import com.bootdo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统登陆注册
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @PreAuthorize("hasRole('CLIENT_USER')")
    public AjaxResponse info(@RequestHeader("token") String token) {
       return sysUserService.findList(new SysUserExample());
    }

}
