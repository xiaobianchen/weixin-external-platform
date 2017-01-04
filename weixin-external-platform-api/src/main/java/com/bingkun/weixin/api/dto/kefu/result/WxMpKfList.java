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
 * Created by chenxiaobian 17/1/2
 * 客服列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfList {

    @SerializedName("kf_list")
    private List<WxMpKfInfo> kfList;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpKfList.class);
    }
}
