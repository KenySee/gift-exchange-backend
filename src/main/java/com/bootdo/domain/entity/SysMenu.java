package com.bootdo.domain.entity;

import com.bootdo.common.persistence.BaseEntity;
import com.bootdo.common.utils.SpringUtils;
import com.bootdo.domain.mapper.SysMenuMapper;

import java.util.Date;

public class SysMenu extends BaseEntity {
    private String name;

    private String icon;

    private String path;

    private Integer serialNum = 0;

    private Long parentId;

    @Override
    public void preInsert() {
        SysMenuMapper mapper = SpringUtils.getBean(SysMenuMapper.class);
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum==null ? 0 : serialNum;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}