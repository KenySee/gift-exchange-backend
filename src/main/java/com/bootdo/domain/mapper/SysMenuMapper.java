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

    @Select("select t1.* from sys_menu t1 inner join (select distinct menu_id from sys_role_menu t2 inner join sys_user_role t3 on t2.role_id = t3.role_id where t3.user_id=#{userId}) t2 on t1.id = t2.menu_id")
    @ResultMap("BaseResultMap")
    public List<SysMenu> selectMenusByUserID(@Param("userId") Long userId);
}
