package com.bingkun.weixin.api.builder.outxml;


import com.bingkun.weixin.api.dto.message.WxMpXmlOutMusicMessage;

/**
 * 音乐消息builder
 */
public final class MusicBuilder extends BaseBuilder<MusicBuilder, WxMpXmlOutMusicMessage> {

    private String title;
    private String description;
    private String hqMusicUrl;
    private String musicUrl;
    private String thumbMediaId;

    public MusicBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MusicBuilder description(String description) {
        this.description = description;
        return this;
    }

    public MusicBuilder hqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
        return this;
    }

    public MusicBuilder musicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
        return this;
    }

    public MusicBuilder thumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        return this;
    }

    @Override
    public WxMpXmlOutMusicMessage build() {
        WxMpXmlOutMusicMessage m = new WxMpXmlOutMusicMessage();
        setCommon(m);
        m.setThumbMediaId(this.thumbMediaId);
        return m;
    }

}
