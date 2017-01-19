package com.bingkun.weixin.common.dto.menu;


import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.apache.commons.codec.Charsets;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/1
 * 微信菜单
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMenu implements Serializable {

    private List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();

    private WxMenuRule matchRule;

    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }

    public static WxMenu fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMenu.class);
    }

    public static WxMenu fromJson(InputStream is) {
        return WxGsonBuilder.create().fromJson(new InputStreamReader(is, Charsets.UTF_8), WxMenu.class);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxMenuButton {

        private String type;
        private String name;
        private String key;
        private String url;
        private List<WxMenuButton> subButtons = new ArrayList<WxMenuButton>();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxMenuRule {
        private String groupId;
        private String sex;
        private String country;
        private String province;
        private String city;
        private String clientPlatformType;
    }

}
