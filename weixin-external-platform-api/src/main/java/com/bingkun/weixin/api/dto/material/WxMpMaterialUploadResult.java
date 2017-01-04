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
public class WxMpMaterialUploadResult implements Serializable {

    private String mediaId;
    private String url;

    public static WxMpMaterialUploadResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialUploadResult.class);
    }
}

