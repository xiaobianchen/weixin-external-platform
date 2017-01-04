package com.bingkun.weixin.api.dto.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxMpXmlOutTextMessage extends WxMpXmlOutMessage {

    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String content;

    public WxMpXmlOutTextMessage() {
        this.msgType = WxConsts.XML_MSG_TEXT;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
