package com.bootdo.service;

import java.util.List;

import com.bootdo.common.page.AjaxResponse;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.example.SysMenuExample;
import com.bootdo.domain.mapper.SysMenuMapper;
import com.bootdo.common.service.CrudService;

/**
 * @author kits
 * @version 0.0.1
 * @date 2018/02/18
 * @time 06:59
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@CacheConfig(cacheNames = "menus")
public class SysMenuService  extends CrudService<SysMenuMapper,SysMenu,SysMenuExample> {

    @Cacheable(key = "'userId='+#p0")
    public List<SysMenu> getMenusByUserId(Long userId) {
        return dao.selectMenusByUserID(userId);
    }

    @Cacheable(key = "'all'")
    public AjaxResponse<List<SysMenu>> findAll() {
        SysMenuExample example = new SysMenuExample();
        return this.findList(example);
    }

    @CacheEvict(key = "'all'")
    public void save(SysMenu menu){
        super.save(menu);
    }

    @CacheEvict(key = "'all'")
    public void update(SysMenu menu){
        this.updateByPrimaryKey(menu);
    }
}
