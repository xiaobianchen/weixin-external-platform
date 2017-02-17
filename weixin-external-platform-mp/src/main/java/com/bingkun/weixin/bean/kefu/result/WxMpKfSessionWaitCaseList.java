package com.bingkun.weixin.bean.kefu.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WxMpKfSessionWaitCaseList {
    /**
     * count 未接入会话数量
     */
    @SerializedName("count")
    private Long count;

    /**
     * waitcaselist 未接入会话列表，最多返回100条数据
     */
    @SerializedName("waitcaselist")
    private List<WxMpKfSession> kfSessionWaitCaseList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfSessionWaitCaseList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json,
                WxMpKfSessionWaitCaseList.class);
    }

    public List<WxMpKfSession> getKfSessionWaitCaseList() {
        return this.kfSessionWaitCaseList;
    }

    public void setKfSessionWaitCaseList(List<WxMpKfSession> kfSessionWaitCaseList) {
        this.kfSessionWaitCaseList = kfSessionWaitCaseList;
    }

}
