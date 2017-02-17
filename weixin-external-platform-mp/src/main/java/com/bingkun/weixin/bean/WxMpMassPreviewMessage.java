package com.bingkun.weixin.bean;


import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 2017/2/16
 */
public class WxMpMassPreviewMessage implements Serializable {
    private String toWxUsername;
    private String msgType;
    private String content;
    private String mediaId;

    public WxMpMassPreviewMessage() {
        super();
    }

    public String getToWxUsername() {
        return this.toWxUsername;
    }

    public void setToWxUsername(String toWxUsername) {
        this.toWxUsername = toWxUsername;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
