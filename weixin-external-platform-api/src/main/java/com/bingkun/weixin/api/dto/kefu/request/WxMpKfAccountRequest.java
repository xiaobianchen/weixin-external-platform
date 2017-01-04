package com.bingkun.weixin.api.dto.kefu.request;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfAccountRequest implements Serializable {

    /**
     * kf_account   完整客服账号，格式为：账号前缀@公众号微信号
     */
    @SerializedName("kf_account")
    private String kfAccount;

    /**
     * nickname   客服昵称，最长6个汉字或12个英文字符
     */
    @SerializedName("nickname")
    private String nickName;

    /**
     * invite_wx   接收绑定邀请的客服微信号
     */
    @SerializedName("invite_wx")
    private String inviteWx;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }


    public static class Builder {
        private String kfAccount;
        private String nickName;
        private String inviteWx;

        public Builder kfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
            return this;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder inviteWx(String inviteWx) {
            this.inviteWx = inviteWx;
            return this;
        }

        public Builder from(WxMpKfAccountRequest origin) {
            this.kfAccount(origin.kfAccount);
            this.nickName(origin.nickName);
            this.inviteWx(origin.inviteWx);
            return this;
        }

        public WxMpKfAccountRequest build() {
            WxMpKfAccountRequest m = new WxMpKfAccountRequest();
            m.kfAccount = this.kfAccount;
            m.nickName = this.nickName;
            m.inviteWx = this.inviteWx;
            return m;
        }
    }

}
