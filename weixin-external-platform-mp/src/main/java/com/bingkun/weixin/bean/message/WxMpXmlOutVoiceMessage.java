package com.bingkun.weixin.bean.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamMediaIdConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;


@XStreamAlias("xml")
public class WxMpXmlOutVoiceMessage extends WxMpXmlOutMessage {


    @XStreamAlias("Voice")
    @XStreamConverter(value = XStreamMediaIdConverter.class)
    private String mediaId;

    public WxMpXmlOutVoiceMessage() {
        this.msgType = WxConsts.XML_MSG_VOICE;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
