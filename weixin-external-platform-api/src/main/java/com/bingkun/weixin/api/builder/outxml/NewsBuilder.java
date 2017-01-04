package com.bingkun.weixin.api.builder.outxml;


import com.bingkun.weixin.api.dto.message.WxMpXmlOutNewsMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息builder
 */
public final class NewsBuilder extends BaseBuilder<NewsBuilder, WxMpXmlOutNewsMessage> {

    protected final List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();

    public NewsBuilder addArticle(WxMpXmlOutNewsMessage.Item item) {
        this.articles.add(item);
        return this;
    }

    @Override
    public WxMpXmlOutNewsMessage build() {
        WxMpXmlOutNewsMessage m = new WxMpXmlOutNewsMessage();
        for (WxMpXmlOutNewsMessage.Item item : this.articles) {
            m.addArticle(item);
        }
        setCommon(m);
        return m;
    }

}