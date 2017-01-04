package com.bingkun.weixin.api.dto.store;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.List;

/**
 * 门店列表结果类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpStoreListResult {
    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpStoreListResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpStoreListResult.class);
    }

    /**
     * 错误码，0为正常
     */
    @SerializedName("errcode")
    private Integer errCode;

    /**
     * 错误信息
     */
    @SerializedName("errmsg")
    private String errMsg;

    /**
     * 门店信息列表
     */
    @SerializedName("business_list")
    private List<WxMpStoreInfo> businessList;

    /**
     * 门店信息总数
     */
    @SerializedName("total_count")
    private Integer totalCount;
}
