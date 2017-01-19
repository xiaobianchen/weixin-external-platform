package com.bingkun.weixin.mp.dto.custombuilder;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;

/**
 * Created by chenxiaobian 17/1/19
 */
public final class VoiceBuilder extends BaseBuilder<VoiceBuilder> {
    private String mediaId;

    public VoiceBuilder() {
        this.msgType = WxConsts.CUSTOM_MSG_VOICE;
    }

    public VoiceBuilder mediaId(String media_id) {
        this.mediaId = media_id;
        return this;
    }

    public WxMpCustomMessage build() {
        WxMpCustomMessage m = super.build();
        m.setMediaId(this.mediaId);
        return m;
    }
}
