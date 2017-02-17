package com.bingkun.weixin.bean.kefu.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WxMpKfList {
    @SerializedName("kf_list")
    private List<WxMpKfInfo> kfList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public List<WxMpKfInfo> getKfList() {
        return this.kfList;
    }

    public void setKfList(List<WxMpKfInfo> kfList) {
        this.kfList = kfList;
    }

    public static WxMpKfList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpKfList.class);
    }
}
