package com.bingkun.weixin.api.dto.template;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMpTemplateMessage implements Serializable {
    private String toUser;
    private String templateId;
    private String url;
    private List<WxMpTemplateData> data = new ArrayList<>();

    public void addWxMpTemplateData(WxMpTemplateData datum) {
        this.data.add(datum);
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }

    public static WxMpTemplateMessageBuilder builder() {
        return new WxMpTemplateMessageBuilder();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxMpTemplateMessageBuilder {
        private String toUser;
        private String templateId;
        private String url;
        private List<WxMpTemplateData> data = new ArrayList<>();

        public WxMpTemplateMessageBuilder toUser(String toUser) {
            this.toUser = toUser;
            return this;
        }

        public WxMpTemplateMessageBuilder templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public WxMpTemplateMessageBuilder url(String url) {
            this.url = url;
            return this;
        }

        public WxMpTemplateMessageBuilder data(List<WxMpTemplateData> data) {
            this.data = data;
            return this;
        }

        public WxMpTemplateMessageBuilder from(WxMpTemplateMessage origin) {
            this.toUser(origin.toUser);
            this.templateId(origin.templateId);
            this.url(origin.url);
            this.data(origin.data);
            return this;
        }

        public WxMpTemplateMessage build() {
            WxMpTemplateMessage m = new WxMpTemplateMessage();
            m.toUser = this.toUser;
            m.templateId = this.templateId;
            m.url = this.url;
            m.data = this.data;
            return m;
        }
    }

}
