package com.bingkun.weixin.api.builder.kefu;

import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 文本消息builder
 */
public final class TextBuilder extends BaseBuilder<TextBuilder> {
    private String content;

    public TextBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_TEXT;
    }

    public TextBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public WxMpKefuMessage build() {
        WxMpKefuMessage m = super.build();
        m.setContent(this.content);
        return m;
    }
}
