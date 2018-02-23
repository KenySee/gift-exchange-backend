package com.bootdo.common.page;

/**
 * Created by bozhou on 2017/11/20.
 */
public class AjaxResponse<T> {
    private boolean success = true;// 是否成功
    private Integer statusCode = 0;//错误代码
    private String message = "操作成功";// 提示信息
    private T result;//返回结果

    public AjaxResponse() {
    }

    public AjaxResponse(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
