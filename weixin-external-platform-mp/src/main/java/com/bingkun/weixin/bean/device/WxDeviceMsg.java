package com.bingkun.weixin.bean.device;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016/12/10.
 */
public class WxDeviceMsg extends AbstractDeviceBean {
    @SerializedName("device_type")
    private String deviceType;
    @SerializedName("device_id")
    private String deviceId;
    @SerializedName("open_id")
    private String openId;
    private String content;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
