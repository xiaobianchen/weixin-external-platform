package com.bingkun.weixin.api.dto.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
public class WxMpXmlOutNewsMessage extends WxMpXmlOutMessage {

    @XStreamAlias("ArticleCount")
    protected int articleCount;

    @XStreamAlias("Articles")
    protected final List<Item> articles = new ArrayList<>();

    public WxMpXmlOutNewsMessage() {
        this.msgType = WxConsts.XML_MSG_NEWS;
    }

    public int getArticleCount() {
        return this.articleCount;
    }

    public void addArticle(Item item) {
        this.articles.add(item);
        this.articleCount = this.articles.size();
    }

    public List<Item> getArticles() {
        return this.articles;
    }


    @XStreamAlias("item")
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {

        @XStreamAlias("Title")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String Title;

        @XStreamAlias("Description")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String Description;

        @XStreamAlias("PicUrl")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String PicUrl;

        @XStreamAlias("Url")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String Url;
    }


}
