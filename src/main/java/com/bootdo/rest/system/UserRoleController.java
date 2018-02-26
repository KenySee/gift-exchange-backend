package com.bootdo.rest.system;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.SysUserRole;
import com.bootdo.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysUserRole> post(@RequestParam(required = true) Long userId,
                                          @RequestParam(required = true) Long roleId){
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        sysUserRoleService.save(userRole);
        return sysUserRoleService.get(userRole.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxResponse<SysUserRole> delete(@RequestParam(required = true) Long id){
        AjaxResponse<SysUserRole> response = sysUserRoleService.get(id);
        SysUserRole userRole = response.getResult();
        sysUserRoleService.delete(userRole);
        return response;
    }
}
