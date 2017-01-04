package com.bingkun.weixin.api.dto.kefu.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by chenxiaobian 17/1/2
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKfSessionGetResult {
    /**
     * kf_account 正在接待的客服，为空表示没有人在接待
     */
    @SerializedName("kf_account")
    private String kfAccount;

    /**
     * createtime 会话接入的时间 ，UNIX时间戳
     */
    @SerializedName("createtime")
    private long createTime;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpKfSessionGetResult fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpKfSessionGetResult.class);
    }
}
