package com.bootdo.domain.entity;

import com.bootdo.common.persistence.BaseEntity;

public class SysUserconnectionKey extends BaseEntity {
    private String userid;

    private String providerid;

    private String provideruserid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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