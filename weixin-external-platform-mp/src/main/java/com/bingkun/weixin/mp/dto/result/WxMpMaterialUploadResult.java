package com.bingkun.weixin.mp.dto.result;


import com.bingkun.weixin.mp.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 */
public class WxMpMaterialUploadResult implements Serializable {

    private String mediaId;
    private String url;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static WxMpMaterialUploadResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialUploadResult.class);
    }

    @Override
    public String toString() {
        return "WxMpMaterialUploadResult [media_id=" + mediaId + ", url=" + url + "]";
    }

}

