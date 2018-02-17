package com.bootdo.domain.entity;

import com.bootdo.common.persistence.BaseEntity;

public class SysRole extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}