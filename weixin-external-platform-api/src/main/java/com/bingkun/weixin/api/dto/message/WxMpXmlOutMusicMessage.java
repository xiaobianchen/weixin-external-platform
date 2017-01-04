package com.bingkun.weixin.api.dto.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public String getHqMusicUrl() {
            return hqMusicUrl;
        }

        public void setHqMusicUrl(String hqMusicUrl) {
            this.hqMusicUrl = hqMusicUrl;
        }
    }

}
