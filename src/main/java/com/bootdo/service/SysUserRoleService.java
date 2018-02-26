package com.bootdo.service;

import com.bootdo.common.service.CrudService;
import com.bootdo.domain.entity.SysUserRole;
import com.bootdo.domain.entity.example.SysUserRoleExample;
import com.bootdo.domain.mapper.SysUserRoleMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author kits
 * @version 0.0.1
 * @date 2017/11/30
 * @time 07:01
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
public class SysUserRoleService  extends CrudService<SysUserRoleMapper,SysUserRole,SysUserRoleExample> {

    @Override
    @CacheEvict(value = {"menus","roles"},key = "'userId='+#p0.userId")
    public void save(SysUserRole userRole){
        super.save(userRole);
    }

    @CacheEvict(value = {"menus","roles"},key = "'userId='+#p0.userId")
    public void delete(SysUserRole userRole){
        this.delete(userRole.getId());
    }
}
