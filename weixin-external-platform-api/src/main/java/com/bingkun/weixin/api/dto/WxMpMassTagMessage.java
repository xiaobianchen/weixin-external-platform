package com.bingkun.weixin.api.dto;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 14/1/4
 * 按标签群发的消息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassTagMessage implements Serializable {

    private Long tagId;
    private String msgtype;
    private String content;
    private String mediaId;

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
