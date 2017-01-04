package com.bingkun.weixin.api.builder.kefu;


import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 卡券消息builder
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
