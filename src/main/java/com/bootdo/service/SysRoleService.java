package com.bootdo.service;

import com.bootdo.common.service.CrudService;
import com.bootdo.domain.entity.SysRole;
import com.bootdo.domain.entity.SysUserRole;
import com.bootdo.domain.entity.example.SysRoleExample;
import com.bootdo.domain.mapper.SysRoleMapper;
import com.bootdo.domain.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
@CacheConfig(cacheNames = "roles")
public class SysRoleService  extends CrudService<SysRoleMapper,SysRole,SysRoleExample> {
    @Autowired
    SysUserRoleMapper sysuserRoleMapper;

    @Cacheable(key = "#p0")
    public List<SysRole> getRole(Long userId) {
        return dao.selectRolesByUserID(userId);
    }

    @Cacheable(key = "#p0")
    @Transactional
    public List<SysRole> insertUserRole(Long userId, Long... roleId) {
        for (Long id : roleId) {
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(id);
            userRole.setUserId(userId);
            userRole.preInsert();
            sysuserRoleMapper.insert(userRole);
        }
        return dao.selectRolesByUserID(userId);
    }
}
