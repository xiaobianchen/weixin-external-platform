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
 * 客服在线列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfOnlineList {
    @SerializedName("kf_online_list")
    private List<WxMpKfInfo> kfOnlineList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfOnlineList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpKfOnlineList.class);
    }
}
