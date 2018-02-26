/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.bootdo.common.service;

import com.bootdo.common.page.AjaxPageInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bootdo.common.page.AjaxResponse;
import com.bootdo.common.persistence.BaseEntity;
import com.bootdo.common.persistence.CrudWithBLOBsMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类,数据库表中包含clob，blob时使用
 */
@Transactional(readOnly = true)
public abstract class CrudWithBlobsService<D extends CrudWithBLOBsMapper<Example,Entity>, Entity extends BaseEntity,Example> extends CrudService<D,Entity,Example>{

	
	/**
	 * 获取单条数据
	 * @param example
	 * @return
	 */
	public AjaxResponse<Entity> getWithBLOBs(Example example) {
		List<Entity> list = dao.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0){
			return getAjaxResponse(list.get(0));
		}
		return null;
	}
	
	/**
	 * 查询列表数据
	 * @param example
	 * @return
	 */
	public AjaxResponse<List<Entity>> findListWithBLOBs(Example example) {
		return getAjaxResponseList(dao.selectByExampleWithBLOBs(example));
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param example
	 * @return
	 */
	public AjaxResponse<AjaxPageInfo<Entity>> findPageWithBLOBs(Integer page, Integer limit, Example example) {
		PageHelper.startPage(page, limit);
		List<Entity> list = dao.selectByExampleWithBLOBs(example);
		return getAjaxResponsePage(list);
	}


	/**
	 * 根据条件更新数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void updateByExampleWithBLOBs(Entity entity,Example example) {
		dao.updateByExampleWithBLOBs(entity,example);
	}

	/**
	 * 根据条件更新数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void updateByPrimaryKeyWithBLOBs(Entity entity) {
		dao.updateByPrimaryKeyWithBLOBs(entity);
	}

}
