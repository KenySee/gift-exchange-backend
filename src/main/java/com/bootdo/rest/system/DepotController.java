package com.bootdo.rest.system;

import com.bootdo.common.page.AjaxPageInfo;
import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysDepot;
import com.bootdo.domain.entity.example.SysDepotExample;
import com.bootdo.service.SysDepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depots")
public class DepotController {

    @Autowired
    private SysDepotService sysDepotService;

    @RequestMapping(method = RequestMethod.GET)
    public AjaxResponse<List<SysDepot>> all(){
        return sysDepotService.findAll();
    }

    @RequestMapping(value = "/childs/{id}",method = RequestMethod.GET)
    public AjaxResponse<AjaxPageInfo<SysDepot>> childs(@PathVariable Long id,
                                                      @RequestParam(required = true) Integer page,
                                                      @RequestParam(required = true) Integer limit){
        SysDepotExample example = new SysDepotExample();
        example.createCriteria().andParentIdEqualTo(id);
        return sysDepotService.findPage(page,limit,example);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResponse<SysDepot> get(@PathVariable Long id){
        return sysDepotService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AjaxResponse<SysDepot> post(@RequestParam(required = true) String name,
                                      @RequestParam(required = true) String description,
                                      @RequestParam(required = true) Integer serialNum,
                                      @RequestParam(required = true) Long parentId){
        SysDepot depot = new SysDepot();
        depot.setName(name);
        depot.setDescription(description);
        depot.setSerialNum(serialNum);
        depot.setParentId(parentId);
        sysDepotService.save(depot);
        return new AjaxResponse<>(depot);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public AjaxResponse<SysDepot> patch(@RequestParam(required = true) Long id,
                                       @RequestParam(required = true) String name,
                                       @RequestParam(required = true) String description,
                                       @RequestParam(required = true) Integer serialNum,
                                       @RequestParam(required = false) Long parentId){
        SysDepot depot = new SysDepot();
        depot.setId(id);
        depot.setName(name);
        depot.setDescription(description);
        depot.setSerialNum(serialNum);
        depot.setParentId(parentId);
        sysDepotService.update(depot);
        return sysDepotService.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResponse<SysDepot> delete(@PathVariable Long id){
        AjaxResponse<SysDepot> response = sysDepotService.get(id);
        sysDepotService.delete(id);
        return response;
    }
}
