package com.bingkun.weixin.bean.kefu.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WxMpKfMsgList {
    @SerializedName("recordlist")
    private List<WxMpKfMsgRecord> records;

    @SerializedName("number")
    private Integer number;

    @SerializedName("msgid")
    private Long msgId;

    public List<WxMpKfMsgRecord> getRecords() {
        return this.records;
    }

    public void setRecords(List<WxMpKfMsgRecord> records) {
        this.records = records;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfMsgList fromJson(String responseContent) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(responseContent, WxMpKfMsgList.class);
    }
}
