package com.bingkun.weixin.mp.dto.custombuilder;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;
/**
 * Created by chenxiaobian 17/1/19
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

    public WxMpCustomMessage build() {
        WxMpCustomMessage m = super.build();
        m.setMediaId(this.mediaId);
        return m;
    }
}
