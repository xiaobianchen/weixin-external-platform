package com.bingkun.weixin.bean.device;

import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016/12/10.
 */
public class TransMsgResp extends AbstractDeviceBean {
    private Integer ret;
    @SerializedName("ret_info")
    private String retInfo;
    @SerializedName("errcode")
    private Integer errCode;
    @SerializedName("errmsg")
    private String errMsg;

    public static TransMsgResp fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, TransMsgResp.class);
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
