package com.bingkun.weixin.api.builder.outxml;


import com.bingkun.weixin.api.dto.message.WxMpXmlOutImageMessage;

/**
 * 图片消息builder
 */
public final class ImageBuilder extends BaseBuilder<ImageBuilder, WxMpXmlOutImageMessage> {

    private String mediaId;

    public ImageBuilder mediaId(String media_id) {
        this.mediaId = media_id;
        return this;
    }

    @Override
    public WxMpXmlOutImageMessage build() {
        WxMpXmlOutImageMessage m = new WxMpXmlOutImageMessage();
        setCommon(m);
        m.setMediaId(this.mediaId);
        return m;
    }

}
