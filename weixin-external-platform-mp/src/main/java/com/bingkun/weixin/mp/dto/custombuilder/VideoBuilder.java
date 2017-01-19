package com.bingkun.weixin.mp.dto.custombuilder;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;

/**
 * Created by chenxiaobian 17/1/19
 */
public final class VideoBuilder extends BaseBuilder<VideoBuilder> {
    private String mediaId;
    private String title;
    private String description;
    private String thumbMediaId;

    public VideoBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_VIDEO;
    }

    public VideoBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public VideoBuilder title(String title) {
        this.title = title;
        return this;
    }

    public VideoBuilder description(String description) {
        this.description = description;
        return this;
    }

    public VideoBuilder thumbMediaId(String thumb_media_id) {
        this.thumbMediaId = thumb_media_id;
        return this;
    }

    public WxMpCustomMessage build() {
        WxMpCustomMessage m = super.build();
        m.setMediaId(this.mediaId);
        m.setTitle(title);
        m.setDescription(description);
        m.setThumbMediaId(thumbMediaId);
        return m;
    }
}
