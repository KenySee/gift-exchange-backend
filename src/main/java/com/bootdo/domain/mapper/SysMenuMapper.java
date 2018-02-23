package com.bootdo.domain.mapper;

import java.util.List;
import com.bootdo.domain.entity.SysMenu;
import com.bootdo.domain.entity.example.SysMenuExample;
import com.bootdo.common.persistence.CrudMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

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
public interface SysMenuMapper  extends CrudMapper<SysMenuExample,SysMenu> {

    @Select("Select idGenMenu(${parentId})")
    public Long IdGen(@Param("parentId") Long parentId);

    @Select("select * from sys_menu where id in(select menu_id from sys_role_menu where role_id in(select role_id from sys_user_role where user_id=#{userId}))")
    @ResultMap("BaseResultMap")
    public List<SysMenu> selectMenusByUserID(@Param("userId") Long userId);
}
