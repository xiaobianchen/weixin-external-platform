package com.bingkun.weixin.api.dto.result;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian 17/1/4
 * 上传群发用的素材的结果
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassUploadResult implements Serializable {

    private String type;
    private String mediaId;
    private long createdAt;

    public static WxMpMassUploadResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMassUploadResult.class);
    }
}