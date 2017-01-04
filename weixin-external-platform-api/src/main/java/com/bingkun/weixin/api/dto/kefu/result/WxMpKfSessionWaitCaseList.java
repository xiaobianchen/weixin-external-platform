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
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfSessionWaitCaseList {
    /**
     * count 未接入会话数量
     */
    @SerializedName("count")
    private Long count;

    /**
     * waitcaselist 未接入会话列表，最多返回100条数据
     */
    @SerializedName("waitcaselist")
    private List<WxMpKfSession> kfSessionWaitCaseList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfSessionWaitCaseList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json,
                WxMpKfSessionWaitCaseList.class);
    }
}
