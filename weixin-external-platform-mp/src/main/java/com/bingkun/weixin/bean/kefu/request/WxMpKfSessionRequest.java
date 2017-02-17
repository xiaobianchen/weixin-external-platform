package com.bingkun.weixin.bean.kefu.request;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMpKfSessionRequest implements Serializable {

    /**
     * kf_account 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @SerializedName("kf_account")
    private String kfAccount;

    /**
     * openid 客户openid
     */
    @SerializedName("openid")
    private String openid;

    public WxMpKfSessionRequest(String kfAccount, String openid) {
        this.kfAccount = kfAccount;
        this.openid = openid;
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }

    public String getKfAccount() {
        return this.kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

}
