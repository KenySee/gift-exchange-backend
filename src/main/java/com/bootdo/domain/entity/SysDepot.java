package com.bootdo.domain.entity;

import com.bootdo.common.persistence.BaseEntity;
import com.bootdo.common.utils.SpringUtils;
import com.bootdo.domain.mapper.SysDepotMapper;

import java.util.Date;

public class SysDepot extends BaseEntity {
    private String name;

    private String description;

    private Integer serialNum;

    private Long parentId;

    @Override
    public void preInsert() {
        SysDepotMapper mapper = SpringUtils.getBean(SysDepotMapper.class);
        Long id = mapper.IdGen(this.parentId);
        this.setId(id);
        this.setCreateTm(new Date());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}