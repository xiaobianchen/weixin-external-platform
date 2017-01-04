package com.bingkun.weixin.api.dto.kefu.request;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }

}
