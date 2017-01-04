package com.bingkun.weixin.api.builder.kefu;


import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 图文消息builder
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
