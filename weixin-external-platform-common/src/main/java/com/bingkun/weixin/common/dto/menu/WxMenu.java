package com.bingkun.weixin.common.dto.menu;


import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/1
 *
 * 微信菜单
 */
public class WxMenu implements Serializable {

    private List<WxMenuButton> buttons = new ArrayList<>();

    private WxMenuRule matchRule;

    public static WxMenu fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMenu.class);
    }

    public static WxMenu fromJson(InputStream is) {
        return WxGsonBuilder.create().fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), WxMenu.class);
    }

    public List<WxMenuButton> getButtons() {
        return this.buttons;
    }

    public void setButtons(List<WxMenuButton> buttons) {
        this.buttons = buttons;
    }

    public WxMenuRule getMatchRule() {
        return this.matchRule;
    }

    public void setMatchRule(WxMenuRule matchRule) {
        this.matchRule = matchRule;
    }

    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
