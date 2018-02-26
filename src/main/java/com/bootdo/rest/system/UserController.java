package com.bootdo.rest.system;

import com.bootdo.common.page.AjaxPageInfo;
import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.domain.entity.example.SysUserExample;
import com.bootdo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/lists/{depotId}",method = RequestMethod.GET)
    public AjaxResponse<AjaxPageInfo<SysUser>> lists(@PathVariable Long depotId,
                                                      @RequestParam(required = true) Integer page,
                                                      @RequestParam(required = true) Integer limit){
        SysUserExample example = new SysUserExample();
        example.createCriteria().andDepotIdEqualTo(depotId);
        return sysUserService.findPage(page,limit,example);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResponse<SysUser> get(@PathVariable Long id){
        return sysUserService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysUser> post(@RequestParam(required = true) String username,
                                      @RequestParam(required = true) String realname,
                                      @RequestParam(required = true) String mobile,
                                      @RequestParam(required = true) String headimage,
                                      @RequestParam(required = true) Long depotId){
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setRealname(realname);
        user.setMobile(mobile);
        user.setHeadimage(headimage);
        user.setDepotId(depotId);
        sysUserService.save(user);
        return new AjaxResponse<>(user);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public AjaxResponse<SysUser> patch(@RequestParam(required = true) Long id,
                                       @RequestParam(required = true) String username,
                                       @RequestParam(required = true) String realname,
                                       @RequestParam(required = true) String mobile,
                                       @RequestParam(required = true) String headimage,
                                       @RequestParam(required = false) Long depotId){
        SysUser user = new SysUser();
        user.setId(id);
        user.setUsername(username);
        user.setRealname(realname);
        user.setMobile(mobile);
        user.setHeadimage(headimage);
        user.setDepotId(depotId);
        sysUserService.update(user);
        return sysUserService.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResponse<SysUser> delete(@PathVariable Long id){
        AjaxResponse<SysUser> response = sysUserService.get(id);
        sysUserService.delete(id);
        return response;
    }
}
