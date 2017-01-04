package com.bingkun.weixin.api.dto.template;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpTemplateIndustry implements Serializable {
    private Industry primaryIndustry;
    private Industry secondIndustry;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Industry implements Serializable {
        private String id;
        private String firstClass;
        private String secondClass;

        @Override
        public String toString() {
            return ToStringUtils.toSimpleString(this);
        }
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpTemplateIndustry fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpTemplateIndustry.class);
    }

    public String toJson() {
        return WxMpGsonBuilder.create().toJson(this);
    }
}
