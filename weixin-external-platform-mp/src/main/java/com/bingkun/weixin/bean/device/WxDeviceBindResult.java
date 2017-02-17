package com.bingkun.weixin.bean.device;

import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016/12/10.
 */
public class WxDeviceBindResult extends AbstractDeviceBean {
    @SerializedName("base_resp")
    private BaseResp baseResp;

    public static WxDeviceBindResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxDeviceBindResult.class);
    }

    public BaseResp getBaseResp() {
        return baseResp;
    }

    public void setBaseResp(BaseResp baseResp) {
        this.baseResp = baseResp;
    }
}
