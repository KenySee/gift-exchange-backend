package com.bootdo.rest.system;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysRoleMenu;
import com.bootdo.domain.entity.SysUserRole;
import com.bootdo.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roleMenus")
public class RoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysRoleMenu> post(@RequestParam(required = true) Long roleId,
                                          @RequestParam(required = true) Long menuId){
        SysRoleMenu roleMenu = new SysRoleMenu();
        roleMenu.setRoleId(roleId);
        roleMenu.setMenuId(menuId);
        sysRoleMenuService.save(roleMenu);
        return sysRoleMenuService.get(roleMenu.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxResponse<SysRoleMenu> delete(@RequestParam(required = true) Long id){
        AjaxResponse<SysRoleMenu> response = sysRoleMenuService.get(id);
        SysRoleMenu roleMenu = response.getResult();
        sysRoleMenuService.delete(roleMenu);
        return response;
    }
}
