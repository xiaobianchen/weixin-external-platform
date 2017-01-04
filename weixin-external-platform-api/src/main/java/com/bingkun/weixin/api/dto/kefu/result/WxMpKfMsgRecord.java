package com.bingkun.weixin.api.dto.kefu.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by chenxiaobian on 2017/1/2.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfMsgRecord {
    /**
     * worker	完整客服帐号，格式为：帐号前缀@公众号微信号
     */
    @SerializedName("worker")
    private String worker;

    /**
     * openid	用户标识
     */
    @SerializedName("openid")
    private String openid;

    /**
     * opercode	操作码，2002（客服发送信息），2003（客服接收消息）
     */
    @SerializedName("opercode")
    private Integer operateCode;

    /**
     * text	聊天记录
     */
    @SerializedName("text")
    private String text;

    /**
     * time	操作时间，unix时间戳
     */
    @SerializedName("time")
    private Long time;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
