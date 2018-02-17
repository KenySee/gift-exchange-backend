package com.bootdo.service;

import com.bootdo.common.service.CrudService;
import com.bootdo.domain.entity.SysUser;
import com.bootdo.domain.entity.example.SysUserExample;
import com.bootdo.domain.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
@CacheConfig(cacheNames = "users")
public class SysUserService  extends CrudService<SysUserMapper,SysUser,SysUserExample> {
    @Autowired
    SysRoleService sysRoleService;

    @Cacheable(key = "#p0")
    public SysUser getUserByUserName(String username) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list = dao.selectByExample(sysUserExample);
        if (list.size() > 0) {
            SysUser sysUser = list.get(0);
            sysUser.setRoleList(sysRoleService.getRole(sysUser.getId()));
            return sysUser;
        }
        return null;
    }

    @Cacheable(key = "#p0")
    public SysUser getUserByUserID(String id) {
        SysUser hyUser = dao.selectByPrimaryKey(id);
        hyUser.setRoleList(sysRoleService.getRole(hyUser.getId()));
        return hyUser;
    }

    @CachePut(key="#p0.id")
    public SysUser saveHyUser(SysUser hyUser){
        if(hyUser.getIsNewRecord()){
            hyUser.preInsert();
            dao.insert(hyUser);
        }else{
            hyUser.preUpdate();
            dao.updateByPrimaryKeySelective(hyUser);
        }
        return hyUser;
    }
}
