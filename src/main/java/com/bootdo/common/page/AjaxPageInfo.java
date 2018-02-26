package com.bootdo.common.page;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by hadoop on 2018/2/25.
 */
public class AjaxPageInfo<T> extends PageInfo<T> {
    public class Pagination{
        public Long total;
        public Integer pageSize;
        public Integer current;
    }
    private Pagination pagination = new Pagination();

    public AjaxPageInfo(List<T> list) {
        super(list);
        this.pagination.current = super.getPageNum();
        this.pagination.pageSize = super.getPageSize();
        this.pagination.total = super.getTotal();
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }


}
