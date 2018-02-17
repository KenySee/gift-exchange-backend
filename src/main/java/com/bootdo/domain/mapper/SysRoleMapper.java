package com.bootdo.domain.mapper;

import com.bootdo.common.persistence.CrudMapper;
import com.bootdo.domain.entity.SysRole;
import com.bootdo.domain.entity.example.SysRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kits
 * @version 0.0.1
 * @date 2017/11/23
 * @time 09:34
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
public interface SysRoleMapper extends CrudMapper<SysRoleExample,SysRole> {
    @Select("select * from sys_role where id in(select role_id from sys_user_role where user_id=#{userId})")
    public List<SysRole> selectRolesByUserID(@Param("userId") String userId);
}
