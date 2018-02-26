package com.bootdo.rest.system;

import com.bootdo.common.page.AjaxPageInfo;
import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.example.SysMenuExample;
import com.bootdo.domain.mapper.SysMenuMapper;
import com.bootdo.service.SysMenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(method = RequestMethod.GET)
    public AjaxResponse<List<SysMenu>> all(){
        return sysMenuService.findAll();
    }

    @RequestMapping(value = "/childs/{id}",method = RequestMethod.GET)
    public AjaxResponse<AjaxPageInfo<SysMenu>> childs(@PathVariable Long id,
                                                      @RequestParam(required = true) Integer page,
                                                      @RequestParam(required = true) Integer limit){
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andParentIdEqualTo(id);
        return sysMenuService.findPage(page,limit,example);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResponse<SysMenu> get(@PathVariable Long id){
        return sysMenuService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysMenu> post(@RequestParam(required = true) String name,
                                      @RequestParam(required = true) String icon,
                                      @RequestParam(required = true) String path,
                                      @RequestParam(required = true) Integer serialNum,
                                      @RequestParam(required = true) Long parentId){
        SysMenu menu = new SysMenu();
        menu.setName(name);
        menu.setIcon(icon);
        menu.setPath(path);
        menu.setSerialNum(serialNum);
        menu.setParentId(parentId);
        sysMenuService.save(menu);
        return new AjaxResponse<>(menu);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public AjaxResponse<SysMenu> patch(@RequestParam(required = true) Long id,
                                       @RequestParam(required = true) String name,
                                       @RequestParam(required = true) String icon,
                                       @RequestParam(required = true) String path,
                                       @RequestParam(required = true) Integer serialNum,
                                       @RequestParam(required = true) Long parentId){
        AjaxResponse<SysMenu> response = sysMenuService.get(id);
        SysMenu menu = response.getResult();
        menu.setName(name);
        menu.setIcon(icon);
        menu.setPath(path);
        menu.setSerialNum(serialNum);
        menu.setParentId(parentId);
        sysMenuService.update(menu);
        return response;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResponse<SysMenu> delete(@PathVariable Long id){
        AjaxResponse<SysMenu> response = sysMenuService.get(id);
        sysMenuService.delete(id);
        return response;
    }
}
