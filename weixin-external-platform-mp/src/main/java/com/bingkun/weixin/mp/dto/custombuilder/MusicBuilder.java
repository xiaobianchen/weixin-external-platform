package com.bingkun.weixin.mp.dto.custombuilder;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;

public final class MusicBuilder extends BaseBuilder<MusicBuilder> {
    private String title;
    private String description;
    private String thumbMediaId;
    private String musicUrl;
    private String hqMusicUrl;

    public MusicBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_MUSIC;
    }

    public MusicBuilder musicUrl(String musicurl) {
        this.musicUrl = musicurl;
        return this;
    }

    public MusicBuilder hqMusicUrl(String hqMusicurl) {
        this.hqMusicUrl = hqMusicurl;
        return this;
    }

    public MusicBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MusicBuilder description(String description) {
        this.description = description;
        return this;
    }

    public MusicBuilder thumbMediaId(String thumb_media_id) {
        this.thumbMediaId = thumb_media_id;
        return this;
    }

    public WxMpCustomMessage build() {
        WxMpCustomMessage m = super.build();
        m.setMusicUrl(this.musicUrl);
        m.setHqMusicUrl(this.hqMusicUrl);
        m.setTitle(title);
        m.setDescription(description);
        m.setThumbMediaId(thumbMediaId);
        return m;
    }
}
