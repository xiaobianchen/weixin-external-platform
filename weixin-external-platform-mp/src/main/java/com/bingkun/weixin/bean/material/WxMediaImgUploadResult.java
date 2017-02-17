package com.bingkun.weixin.bean.material;


import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;


public class WxMediaImgUploadResult implements Serializable {
    private String url;

    public static WxMediaImgUploadResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMediaImgUploadResult.class);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
