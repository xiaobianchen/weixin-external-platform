package com.bingkun.weixin.bean.menu;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016-11-25.
 */
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

    public WxMpSelfMenuInfo getSelfMenuInfo() {
        return selfMenuInfo;
    }

    public void setSelfMenuInfo(WxMpSelfMenuInfo selfMenuInfo) {
        this.selfMenuInfo = selfMenuInfo;
    }

    public Integer getIsMenuOpen() {
        return isMenuOpen;
    }

    public void setIsMenuOpen(Integer isMenuOpen) {
        this.isMenuOpen = isMenuOpen;
    }
}
