package com.bingkun.weixin.builder.kefu;


import com.bingkun.weixin.bean.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 卡券消息builder
 * 用法: WxMpKefuMessage m = WxMpKefuMessage.WXCARD().cardId(...).toUser(...).build();
 */
public final class WxCardBuilder extends BaseBuilder<WxCardBuilder> {
    private String cardId;

    public WxCardBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_WXCARD;
    }

    public WxCardBuilder cardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    @Override
    public WxMpKefuMessage build() {
        WxMpKefuMessage m = super.build();
        m.setCardId(this.cardId);
        return m;
    }
}
