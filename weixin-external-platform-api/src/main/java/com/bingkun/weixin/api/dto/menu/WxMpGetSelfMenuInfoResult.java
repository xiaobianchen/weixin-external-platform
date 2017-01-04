package com.bingkun.weixin.api.dto.menu;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpGetSelfMenuInfoResult {
    @SerializedName("selfmenu_info")
    private WxMpSelfMenuInfo selfMenuInfo;

    @SerializedName("is_menu_open")
    private Integer isMenuOpen;

    public static WxMpGetSelfMenuInfoResult fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMpGetSelfMenuInfoResult.class);
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
