package com.bingkun.weixin.common.dto;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 * jspai 签名
 */


public class WxJsapiSignature implements Serializable {

    private String appid;

    private String noncestr;

    private long timestamp;

    private String url;

    private String signature;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
