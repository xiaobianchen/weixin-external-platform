package com.bingkun.weixin.builder.kefu;


import com.bingkun.weixin.bean.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息builder
 * 用法:
 * WxMpKefuMessage m = WxMpKefuMessage.NEWS().addArticle(article).toUser(...).build();
 */
public final class NewsBuilder extends BaseBuilder<NewsBuilder> {

    private List<WxMpKefuMessage.WxArticle> articles = new ArrayList<>();

    public NewsBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_NEWS;
    }

    public NewsBuilder addArticle(WxMpKefuMessage.WxArticle article) {
        this.articles.add(article);
        return this;
    }

    @Override
    public WxMpKefuMessage build() {
        WxMpKefuMessage m = super.build();
        m.setArticles(this.articles);
        return m;
    }
}
