package com.bingkun.weixin.api.dto.tag;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.List;

/**
 * 获取标签下粉丝列表的结果对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxTagListUser {

    public static WxTagListUser fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxTagListUser.class);
    }

    public String toJson() {
        return WxMpGsonBuilder.create().toJson(this);
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    /**
     * "count":2,这次获取的粉丝数量
     */
    @SerializedName("count")
    private Integer count;

    /**
     * "data" 粉丝列表
     */
    @SerializedName("data")
    private WxTagListUserData data;

    /**
     * "next_openid" 拉取列表最后一个用户的openid
     */
    @SerializedName("next_openid")
    private String nextOpenid;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxTagListUserData {
        @Override
        public String toString() {
            return ToStringUtils.toSimpleString(this);
        }

        /**
         * openid 列表
         */
        @SerializedName("openid")
        private List<String> openidList;
    }
}
