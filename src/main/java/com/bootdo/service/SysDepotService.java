package com.bootdo.service;

import java.util.List;

import com.bootdo.common.page.AjaxResponse;
import com.bootdo.domain.entity.SysMenu;
import org.springframework.stereotype.Service;
import com.bootdo.domain.entity.SysDepot;
import com.bootdo.domain.entity.example.SysDepotExample;
import com.bootdo.domain.mapper.SysDepotMapper;
import com.bootdo.common.service.CrudService;

/**
 * @author kits
 * @version 0.0.1
 * @date 2018/02/26
 * @time 14:47
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
public class SysDepotService  extends CrudService<SysDepotMapper,SysDepot,SysDepotExample> {

    public AjaxResponse<List<SysDepot>> findAll() {
        SysDepotExample example = new SysDepotExample();
        return this.findList(example);
    }
    public void save(SysDepot depot){
        super.save(depot);
    }
    public void update(SysDepot depot){
        this.updateByPrimaryKey(depot);
    }
}
