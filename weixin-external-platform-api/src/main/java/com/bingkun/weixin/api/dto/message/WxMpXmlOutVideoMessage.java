package com.bingkun.weixin.api.dto.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@XStreamAlias("xml")
@Data
@Builder
public class WxMpXmlOutVideoMessage extends WxMpXmlOutMessage {
    @XStreamAlias("Video")
    protected final Video video = new Video();

    public WxMpXmlOutVideoMessage() {
        this.msgType = WxConsts.XML_MSG_VIDEO;
    }

    @XStreamAlias("Video")
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Video {

        @XStreamAlias("MediaId")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String mediaId;

        @XStreamAlias("Title")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String title;

        @XStreamAlias("Description")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String description;
    }

}
