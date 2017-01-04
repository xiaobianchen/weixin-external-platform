package com.bingkun.weixin.mp.dto.custombuilder;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;

import java.util.ArrayList;
import java.util.List;

public final class NewsBuilder extends BaseBuilder<NewsBuilder> {

    private List<WxMpCustomMessage.WxArticle> articles = new ArrayList<WxMpCustomMessage.WxArticle>();

    public NewsBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_NEWS;
    }

    public NewsBuilder addArticle(WxMpCustomMessage.WxArticle article) {
        this.articles.add(article);
        return this;
    }

    public WxMpCustomMessage build() {
        WxMpCustomMessage m = super.build();
        m.setArticles(this.articles);
        return m;
    }
}
