package com.bingkun.weixin.bean;


import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * 按标签群发的消息
 * Created by chenxiaobian on 2017/2/16
 */
public class WxMpMassTagMessage implements Serializable {

    private Long tagId;
    private String msgType;
    private String content;
    private String mediaId;
    private boolean isSendAll = false;
    private boolean sendIgnoreReprint = false;

    public WxMpMassTagMessage() {
        super();
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

    public Long getTagId() {
        return this.tagId;
    }

    /**
     * 如果不设置则就意味着发给所有用户
     *
     * @param tagId 标签id
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public boolean isSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    /**
     * @param sendIgnoreReprint 文章被判定为转载时，是否继续进行群发操作。
     */
    public void setSendIgnoreReprint(boolean sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }

    /**
     * 是否群发给所有用户
     */
    public boolean isSendAll() {
        return isSendAll;
    }

    public void setSendAll(boolean sendAll) {
        if (sendAll) {
            this.tagId = null;
        }

        isSendAll = sendAll;
    }
}
