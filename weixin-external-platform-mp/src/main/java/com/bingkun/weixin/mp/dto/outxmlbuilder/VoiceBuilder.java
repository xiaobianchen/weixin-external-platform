package com.bingkun.weixin.mp.dto.outxmlbuilder;


import com.bingkun.weixin.mp.dto.WxMpXmlOutVoiceMessage;

/**
 * Created by chenxiaobian 17/1/20
 * 语音消息builder
 */
public final class VoiceBuilder extends BaseBuilder<VoiceBuilder, WxMpXmlOutVoiceMessage> {

    private String mediaId;

    public VoiceBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public WxMpXmlOutVoiceMessage build() {
        WxMpXmlOutVoiceMessage m = new WxMpXmlOutVoiceMessage();
        setCommon(m);
        m.setMediaId(mediaId);
        return m;
    }

}
