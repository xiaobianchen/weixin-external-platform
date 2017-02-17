package com.bingkun.weixin.bean.menu;

import com.bingkun.weixin.common.dto.menu.WxMenuButton;
import com.bingkun.weixin.common.dto.menu.WxMenuRule;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 公众号专用的菜单类，可能包含个性化菜单
 */
public class WxMpMenu {
    @SerializedName("menu")
    private WxMpConditionalMenu menu;

    @SerializedName("conditionalmenu")
    private List<WxMpConditionalMenu> conditionalMenu;

    public static WxMpMenu fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMpMenu.class);
    }

    public WxMpConditionalMenu getMenu() {
        return menu;
    }

    public void setMenu(WxMpConditionalMenu menu) {
        this.menu = menu;
    }

    public List<WxMpConditionalMenu> getConditionalMenu() {
        return conditionalMenu;
    }

    public void setConditionalMenu(List<WxMpConditionalMenu> conditionalMenu) {
        this.conditionalMenu = conditionalMenu;
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }

    public static class WxMpConditionalMenu {
        @SerializedName("button")
        private List<WxMenuButton> buttons;
        @SerializedName("matchrule")
        private WxMenuRule rule;
        @SerializedName("menuid")
        private String menuId;

        @Override
        public String toString() {
            return ToStringUtils.toSimpleString(this);
        }

        public List<WxMenuButton> getButtons() {
            return buttons;
        }

        public void setButtons(List<WxMenuButton> buttons) {
            this.buttons = buttons;
        }

        public WxMenuRule getRule() {
            return rule;
        }

        public void setRule(WxMenuRule rule) {
            this.rule = rule;
        }

        public String getMenuId() {
            return menuId;
        }

        public void setMenuId(String menuId) {
            this.menuId = menuId;
        }
    }

}
