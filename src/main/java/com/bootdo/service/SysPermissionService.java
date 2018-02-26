package com.bootdo.service;

import com.bootdo.common.service.CrudService;
import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.SysRole;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.domain.entity.example.SysUserExample;
import com.bootdo.domain.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hadoop on 2018/2/23.
 */
@Service
@CacheConfig(cacheNames = "permissions")
public class SysPermissionService extends CrudService<SysUserMapper,SysUser,SysUserExample> {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserService userService;

    public SysUser fetchUserPermission(String username) {
        SysUser sysUser = userService.getUserByUserName(username);
        if (sysUser != null) {
            List<SysRole> roles = sysRoleService.getRolesByUserId(sysUser.getId());
            sysUser.setRoleList(roles);
            List<SysMenu> menus = sysMenuService.getMenusByUserId(sysUser.getId());
            sysUser.setMenuList(menus);
        }
        return sysUser;
    }
}
