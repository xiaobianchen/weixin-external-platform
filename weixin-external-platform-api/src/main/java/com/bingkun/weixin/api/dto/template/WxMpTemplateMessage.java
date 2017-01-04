package com.bingkun.weixin.api.dto.template;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<WxMpTemplateData> getData() {
        return data;
    }

    public void setData(List<WxMpTemplateData> data) {
        this.data = data;
    }

    public static WxMpTemplateMessageBuilder builder() {
        return new WxMpTemplateMessageBuilder();
    }


    public static class WxMpTemplateMessageBuilder {
        private String toUser;
        private String templateId;
        private String url;
        private List<WxMpTemplateData> data = new ArrayList<>();

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            this.toUser = toUser;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<WxMpTemplateData> getData() {
            return data;
        }

        public void setData(List<WxMpTemplateData> data) {
            this.data = data;
        }

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
