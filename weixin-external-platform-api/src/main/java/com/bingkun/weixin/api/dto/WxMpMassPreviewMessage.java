package com.bingkun.weixin.api.dto;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 14/1/4
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassPreviewMessage implements Serializable {
    private String toWxUsername;
    private String msgType;
    private String content;
    private String mediaId;

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
