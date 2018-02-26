package com.bootdo.common.page;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by hadoop on 2018/2/25.
 */
public class AjaxPageInfo<T> {
    public class Pagination{
        public Integer total;
        public Integer pageSize;
        public Integer current;
    }
    private List<T> list;
    private Pagination pagination = new Pagination();

    public AjaxPageInfo(List<T> list) {
        PageInfo<T> page = new PageInfo(list);
        this.list = page.getList();
        this.pagination.current = page.getPageNum();
        this.pagination.pageSize = page.getPageSize();
        this.pagination.total = this.list.size();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }


}
