package com.bingkun.weixin.api.dto.result;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/4
 * 群发消息一发送就返回的结果
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassSendResult implements Serializable {

    private String errorCode;
    private String errorMsg;
    private String msgId;
    private String msgDataId;

    public static WxMpMassSendResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMassSendResult.class);
    }
}
