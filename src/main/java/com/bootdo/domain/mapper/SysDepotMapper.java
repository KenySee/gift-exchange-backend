package com.bootdo.domain.mapper;

import java.util.List;
import com.bootdo.domain.entity.SysDepot;
import com.bootdo.domain.entity.example.SysDepotExample;
import com.bootdo.common.persistence.CrudMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
public interface SysDepotMapper  extends CrudMapper<SysDepotExample,SysDepot> {

    @Select("Select idGenDepot(${parentId})")
    public Long IdGen(@Param("parentId") Long parentId);
}
