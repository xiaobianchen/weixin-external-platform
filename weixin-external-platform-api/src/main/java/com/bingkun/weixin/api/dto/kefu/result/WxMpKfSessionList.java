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
 * Created by chenxiaobian on 17/1/2
 * 会话列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfSessionList {
    /**
     * 会话列表
     */
    @SerializedName("sessionlist")
    private List<WxMpKfSession> kfSessionList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfSessionList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json,
                WxMpKfSessionList.class);
    }
}
