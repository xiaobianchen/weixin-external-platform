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
public class WxMpXmlOutMusicMessage extends WxMpXmlOutMessage {

    @XStreamAlias("Music")
    protected final Music music = new Music();

    public WxMpXmlOutMusicMessage() {
        this.msgType = WxConsts.XML_MSG_MUSIC;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.music.setThumbMediaId(thumbMediaId);
    }

    @XStreamAlias("Music")
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Music {

        @XStreamAlias("Title")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String title;

        @XStreamAlias("Description")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String description;

        @XStreamAlias("ThumbMediaId")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String thumbMediaId;

        @XStreamAlias("MusicUrl")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String musicUrl;

        @XStreamAlias("HQMusicUrl")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String hqMusicUrl;
    }

}
