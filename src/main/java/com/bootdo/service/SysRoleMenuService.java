package com.bootdo.service;

import java.util.List;

import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.SysRole;
import com.bootdo.domain.entity.SysUserRole;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.bootdo.domain.entity.SysRoleMenu;
import com.bootdo.domain.entity.example.SysRoleMenuExample;
import com.bootdo.domain.mapper.SysRoleMenuMapper;
import com.bootdo.common.service.CrudService;

/**
 * @author kits
 * @version 0.0.1
 * @date 2018/02/23
 * @time 09:55
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@CacheConfig(cacheNames = "role_users")
public class SysRoleMenuService  extends CrudService<SysRoleMenuMapper,SysRoleMenu,SysRoleMenuExample> {

    @Override
    @CacheEvict(value = {"menus"},allEntries=true)
    public void save(SysRoleMenu roleMenu){
        super.save(roleMenu);
    }

    @CacheEvict(value = {"menus"},allEntries=true)
    public void delete(SysRoleMenu roleMenu){
        this.delete(roleMenu.getId());
    }
}
