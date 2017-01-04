package com.bingkun.weixin.api.dto.material;


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
public class WxMpMaterialVideoInfoResult implements Serializable {

    private String title;
    private String description;
    private String downUrl;

    public static WxMpMaterialVideoInfoResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialVideoInfoResult.class);
    }
}
