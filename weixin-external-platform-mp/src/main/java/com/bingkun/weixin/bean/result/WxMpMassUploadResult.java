package com.bingkun.weixin.bean.result;

import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * 上传群发用的素材的结果
 * 视频和图文消息需要在群发前上传素材
 */
public class WxMpMassUploadResult implements Serializable {

    private String type;
    private String mediaId;
    private long createdAt;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public static WxMpMassUploadResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMassUploadResult.class);
    }

    @Override
    public String toString() {
        return "WxUploadResult [type=" + this.type + ", media_id=" + this.mediaId + ", created_at=" + this.createdAt + "]";
    }

}
