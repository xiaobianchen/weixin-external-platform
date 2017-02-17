package com.bingkun.weixin.bean.material;

import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

public class WxMpMaterialVideoInfoResult implements Serializable {


    private String title;
    private String description;
    private String downUrl;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownUrl() {
        return this.downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public static WxMpMaterialVideoInfoResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialVideoInfoResult.class);
    }

    @Override
    public String toString() {
        return "WxMpMaterialVideoInfoResult [title=" + this.title + ", description=" + this.description + ", downUrl=" + this.downUrl + "]";
    }

}
