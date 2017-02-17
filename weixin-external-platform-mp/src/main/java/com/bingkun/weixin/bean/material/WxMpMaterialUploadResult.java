package com.bingkun.weixin.bean.material;


import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

public class WxMpMaterialUploadResult implements Serializable {


    private String mediaId;
    private String url;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static WxMpMaterialUploadResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialUploadResult.class);
    }

    @Override
    public String toString() {
        return "WxMpMaterialUploadResult [media_id=" + this.mediaId + ", url=" + this.url + "]";
    }

}

