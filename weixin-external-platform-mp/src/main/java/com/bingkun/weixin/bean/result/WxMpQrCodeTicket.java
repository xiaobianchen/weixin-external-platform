package com.bingkun.weixin.bean.result;


import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * 换取二维码的Ticket
 */
public class WxMpQrCodeTicket implements Serializable {

    protected String ticket;
    protected int expire_seconds = -1;
    protected String url;

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 如果返回-1说明是永久
     */
    public int getExpire_seconds() {
        return this.expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static WxMpQrCodeTicket fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpQrCodeTicket.class);
    }

    @Override
    public String toString() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
