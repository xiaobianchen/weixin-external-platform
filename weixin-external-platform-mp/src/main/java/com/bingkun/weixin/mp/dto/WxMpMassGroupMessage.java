package com.bingkun.weixin.mp.dto;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * 分组群发的消息
 */
public class WxMpMassGroupMessage implements Serializable {

    private Long groupId;
    private String msgtype;
    private String content;
    private String mediaId;

    public WxMpMassGroupMessage() {
        super();
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
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

    public Long getGroupId() {
        return groupId;
    }

    /**
     * 如果不设置则就意味着发给所有用户
     *
     * @param groupId
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
