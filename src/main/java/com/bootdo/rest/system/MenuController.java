package com.bootdo.rest.system;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.example.SysMenuExample;
import com.bootdo.domain.mapper.SysMenuMapper;
import com.bootdo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(method = RequestMethod.GET)
    public AjaxResponse<List<SysMenu>> all(){
        SysMenuExample example = new SysMenuExample();
        return sysMenuService.findList(example);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResponse<SysMenu> get(@PathVariable Long id){
        return sysMenuService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysMenu> post(String name,String icon,String path,Long parnetId){
        SysMenu menu = new SysMenu();
        menu.setName(name);
        menu.setIcon(icon);
        menu.setPath(path);
        menu.setParentId(parnetId);
        sysMenuService.save(menu);
        return new AjaxResponse<>(menu);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public AjaxResponse<SysMenu> patch(Long id,String name,String icon,String path,Long parentId){
        AjaxResponse<SysMenu> response = sysMenuService.get(id);
        SysMenu menu = response.getResult();
        menu.setName(name);
        menu.setIcon(icon);
        menu.setPath(path);
        menu.setParentId(parentId);
        sysMenuService.updateByPrimaryKey(menu);
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxResponse<SysMenu> delete(Long id){
        AjaxResponse<SysMenu> response = sysMenuService.get(id);
        sysMenuService.delete(id);
        return response;
    }
}
