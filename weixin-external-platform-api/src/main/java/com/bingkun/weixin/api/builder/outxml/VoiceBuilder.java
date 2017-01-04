package com.bingkun.weixin.api.builder.outxml;

import com.bingkun.weixin.api.dto.message.WxMpXmlOutVoiceMessage;

/**
 * 语音消息builder
 */
public final class VoiceBuilder extends BaseBuilder<VoiceBuilder, WxMpXmlOutVoiceMessage> {

    private String mediaId;

    public VoiceBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public WxMpXmlOutVoiceMessage build() {
        WxMpXmlOutVoiceMessage m = new WxMpXmlOutVoiceMessage();
        setCommon(m);
        m.setMediaId(this.mediaId);
        return m;
    }

}
