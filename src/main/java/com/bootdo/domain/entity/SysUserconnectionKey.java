package com.bootdo.domain.entity;

import com.bootdo.common.persistence.BaseEntity;

public class SysUserconnectionKey extends BaseEntity {
    private Long userid;

    private String providerid;

    private String provideruserid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getProviderid() {
        return providerid;
    }

    public void setProviderid(String providerid) {
        this.providerid = providerid == null ? null : providerid.trim();
    }

    public String getProvideruserid() {
        return provideruserid;
    }

    public void setProvideruserid(String provideruserid) {
        this.provideruserid = provideruserid == null ? null : provideruserid.trim();
    }
}