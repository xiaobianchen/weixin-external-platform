package com.bingkun.weixin.common.dto.result;


import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/***
 * Created by chenxiaobian on 17/1/1.
 * 微信媒体上传
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMediaUploadResult implements Serializable {

    private String type;
    private String mediaId;
    private String thumbMediaId;
    private long createdAt;

    public static WxMediaUploadResult fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMediaUploadResult.class);
    }
}
