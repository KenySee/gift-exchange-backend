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

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @RequestMapping(value = "/childs",method = RequestMethod.GET)
    public AjaxResponse<List<SysMenu>> childs(Long parentId){
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<SysMenu> childs = sysMenuMapper.selectByExample(example);
        return new AjaxResponse<>(childs);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResponse<SysMenu> get(@PathVariable Long id){
        SysMenu menu = sysMenuMapper.selectByPrimaryKey(id);
        return new AjaxResponse<>(menu);
    }
    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysMenu> save(String name,String icon,String path,Long parnetId){
        SysMenu menu = new SysMenu();
        menu.setName(name);
        menu.setIcon(icon);
        menu.setPath(path);
        menu.setParentId(parnetId);
        sysMenuService.save(menu);
        return new AjaxResponse<>(menu);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AjaxResponse<SysMenu> update(Long id,String name,String icon,String path,Long parnet){
        SysMenu menu = sysMenuMapper.selectByPrimaryKey(id);
        menu.setName(name);
        menu.setIcon(icon);
        menu.setPath(path);
        menu.setParentId(parnet);
        sysMenuService.updateByPrimaryKey(menu);
        return new AjaxResponse<>(menu);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxResponse<SysMenu> delete(Long id){
        SysMenu menu = sysMenuMapper.selectByPrimaryKey(id);
        sysMenuService.delete(id);
        return new AjaxResponse<>(menu);
    }
}
