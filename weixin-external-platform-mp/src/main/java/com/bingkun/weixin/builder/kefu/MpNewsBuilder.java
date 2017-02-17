package com.bingkun.weixin.builder.kefu;

import com.bingkun.weixin.bean.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 图文消息builder
 * 用法:
 * WxMpKefuMessage m = WxMpKefuMessage.NEWS().mediaId("xxxxx").toUser(...).build();
 */
public final class MpNewsBuilder extends BaseBuilder<MpNewsBuilder> {
    private String mediaId;

    public MpNewsBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_MPNEWS;
    }

    public MpNewsBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    @Override
    public WxMpKefuMessage build() {
        WxMpKefuMessage m = super.build();
        m.setMpNewsMediaId(this.mediaId);
        return m;
    }
}
