package com.bingkun.weixin.api.dto.result;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpOAuth2AccessToken implements Serializable {

    private String accessToken;

    private int expiresIn = -1;

    private String refreshToken;

    private String openId;

    private String scope;

    private String unionId;

    public static WxMpOAuth2AccessToken fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpOAuth2AccessToken.class);
    }
}
