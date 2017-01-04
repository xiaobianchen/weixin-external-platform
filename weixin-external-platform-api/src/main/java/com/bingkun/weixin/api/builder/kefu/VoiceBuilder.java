package com.bingkun.weixin.api.builder.kefu;

import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 语音消息builder
 */
public final class VoiceBuilder extends BaseBuilder<VoiceBuilder> {
    private String mediaId;

    public VoiceBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_VOICE;
    }

    public VoiceBuilder mediaId(String media_id) {
        this.mediaId = media_id;
        return this;
    }

    @Override
    public WxMpKefuMessage build() {
        WxMpKefuMessage m = super.build();
        m.setMediaId(this.mediaId);
        return m;
    }
}
