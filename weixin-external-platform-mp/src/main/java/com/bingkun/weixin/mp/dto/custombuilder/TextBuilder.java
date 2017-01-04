package com.bingkun.weixin.mp.dto.custombuilder;


import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;

public final class TextBuilder extends BaseBuilder<TextBuilder> {
    private String content;

    public TextBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_TEXT;
    }

    public TextBuilder content(String content) {
        this.content = content;
        return this;
    }

    public WxMpCustomMessage build() {
        WxMpCustomMessage m = super.build();
        m.setContent(this.content);
        return m;
    }
}
