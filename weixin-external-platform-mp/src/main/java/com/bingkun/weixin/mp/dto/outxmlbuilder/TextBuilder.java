package com.bingkun.weixin.mp.dto.outxmlbuilder;


import com.bingkun.weixin.mp.dto.WxMpXmlOutTextMessage;

/**
 * Created by chenxiaobian 17/1/20
 * 文本消息builder
 */
public final class TextBuilder extends BaseBuilder<TextBuilder, WxMpXmlOutTextMessage> {
    private String content;

    public TextBuilder content(String content) {
        this.content = content;
        return this;
    }

    public WxMpXmlOutTextMessage build() {
        WxMpXmlOutTextMessage m = new WxMpXmlOutTextMessage();
        setCommon(m);
        m.setContent(this.content);
        return m;
    }
}
