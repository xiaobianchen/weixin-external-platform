package com.bingkun.weixin.mp.dto.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian 17/1/19
 *
 * 群发消息一发送就返回的结果
 * 真正的群发消息是否发送成功要看
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassSendResult implements Serializable {

    private String errorCode;
    private String errorMsg;
    private String msgId;

    public static WxMpMassSendResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMassSendResult.class);
    }
}
