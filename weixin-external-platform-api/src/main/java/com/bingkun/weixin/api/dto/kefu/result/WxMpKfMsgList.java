package com.bingkun.weixin.api.dto.kefu.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/2.
 * 客服消息列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfMsgList {

    @SerializedName("recordlist")
    private List<WxMpKfMsgRecord> records;

    @SerializedName("number")
    private Integer number;

    @SerializedName("msgid")
    private Long msgId;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfMsgList fromJson(String responseContent) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(responseContent, WxMpKfMsgList.class);
    }
}
