package com.bingkun.weixin.api.builder.kefu;


import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;

/**
 * 获得消息builder
 */
public final class ImageBuilder extends BaseBuilder<ImageBuilder> {
    private String mediaId;

    public ImageBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_IMAGE;
    }

    public ImageBuilder mediaId(String media_id) {
        this.mediaId = media_id;
        return this;
    }

    @Override
    public WxMpKefuMessage build() {
        WxMpKefuMessage m = super.build();
        m.setMediaId(this.mediaId);
        return m;
    }
}
