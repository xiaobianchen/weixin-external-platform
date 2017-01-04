package com.bingkun.weixin.api.dto.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamMediaIdConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Builder;

@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
public class WxMpXmlOutImageMessage extends WxMpXmlOutMessage {

    @XStreamAlias("Image")
    @XStreamConverter(value = XStreamMediaIdConverter.class)
    private String mediaId;

    public WxMpXmlOutImageMessage() {
        this.msgType = WxConsts.XML_MSG_IMAGE;
    }

}
