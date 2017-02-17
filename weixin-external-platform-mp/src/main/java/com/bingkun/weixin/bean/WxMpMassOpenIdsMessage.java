package com.bingkun.weixin.bean;


import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * openid列表群发的消息
 * Created by chenxiaobian on 2017/2/16
 */
public class WxMpMassOpenIdsMessage implements Serializable {
    private static final long serialVersionUID = -8022910911104788999L;

    private List<String> toUsers = new ArrayList<>();
    private String msgType;
    private String content;
    private String mediaId;
    private boolean sendIgnoreReprint = false;

    public WxMpMassOpenIdsMessage() {
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

    /**
     * openid列表，最多支持10,000个
     */
    public List<String> getToUsers() {
        return this.toUsers;
    }

    /**
     * 添加openid，最多支持10,000个
     *
     * @param openid
     */
    public void addUser(String openid) {
        this.toUsers.add(openid);
    }

    /**
     * 提供set方法，方便客户端直接设置所有群发对象的openid列表
     *
     * @param toUsers
     */
    public void setToUsers(List<String> toUsers) {
        this.toUsers = toUsers;
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
}
