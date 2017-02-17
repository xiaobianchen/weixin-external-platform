package com.bingkun.weixin.bean.device;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016/12/10.
 */

public class RespMsg extends AbstractDeviceBean {
    @SerializedName("ret_code")
    private Integer retCode;
    @SerializedName("error_info")
    private String errorInfo;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
