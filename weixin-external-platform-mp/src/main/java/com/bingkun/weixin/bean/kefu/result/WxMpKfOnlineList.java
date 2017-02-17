package com.bingkun.weixin.bean.kefu.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WxMpKfOnlineList {
    @SerializedName("kf_online_list")
    private List<WxMpKfInfo> kfOnlineList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public List<WxMpKfInfo> getKfOnlineList() {
        return this.kfOnlineList;
    }

    public void setKfOnlineList(List<WxMpKfInfo> kfOnlineList) {
        this.kfOnlineList = kfOnlineList;
    }

    public static WxMpKfOnlineList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpKfOnlineList.class);
    }
}
