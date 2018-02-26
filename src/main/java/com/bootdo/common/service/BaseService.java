package com.bootdo.common.service;

import com.bootdo.common.page.AjaxPageInfo;
import com.github.pagehelper.PageInfo;
import com.bootdo.common.page.AjaxResponse;

import java.util.List;

/**
 * Created by bozhou on 2017/11/20.
 */
public class BaseService<T> {
    public AjaxResponse<T> getAjaxResponse(T t){
        AjaxResponse<T> ajaxResponse = new AjaxResponse();
        ajaxResponse.setResult(t);
        return ajaxResponse;
    }

    public AjaxResponse<List<T>> getAjaxResponseList(List<T> list){
        AjaxResponse<List<T>> ajaxResponse = new AjaxResponse();
        ajaxResponse.setResult(list);
        return ajaxResponse;
    }

    public AjaxResponse<AjaxPageInfo<T>> getAjaxResponsePage(List<T> list){
        AjaxResponse<AjaxPageInfo<T>> ajaxResponse = new AjaxResponse();
        AjaxPageInfo<T> pageInfo = new AjaxPageInfo(list);
        ajaxResponse.setResult(pageInfo);
        return ajaxResponse;
    }
}
