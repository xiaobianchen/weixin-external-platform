package com.bingkun.weixin.common.dto;


import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxAccessToken implements Serializable {
    private String accessToken;

    private int expiresIn = -1;

    public static WxAccessToken fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxAccessToken.class);
    }
}
