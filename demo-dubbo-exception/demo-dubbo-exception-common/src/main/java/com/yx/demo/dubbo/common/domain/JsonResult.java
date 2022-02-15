package com.yx.demo.dubbo.common.domain;

import java.io.Serializable;

/**
 * @author zhonghuashishan
 * @version 1.0
 */
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 业务数据
     */
    private Object data;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误提示语
     */
    private String errorMessage;

    public JsonResult(Object data) {
        this.success = true;
        this.data = data;
        this.errorCode = null;
        this.errorMessage = null;
    }

    public JsonResult(String errorCode, String errorMessage) {
        this.success = false;
        this.data = null;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public JsonResult(Boolean success, Object data, String errorCode, String errorMessage) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}