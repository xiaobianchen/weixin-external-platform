package com.bingkun.weixin.mp.dto;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * OpenId列表群发的消息
 */
public class WxMpMassOpenIdsMessage implements Serializable {

    private List<String> toUsers = new ArrayList<String>();
    private String msgType;
    private String content;
    private String mediaId;

    public WxMpMassOpenIdsMessage() {
        super();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }

    /**
     * OpenId列表，最多支持10,000个
     *
     * @return
     */
    public List<String> getToUsers() {
        return toUsers;
    }

    /**
     * 添加OpenId，最多支持10,000个
     *
     * @param openId
     */
    public void addUser(String openId) {
        this.toUsers.add(openId);
    }
}
