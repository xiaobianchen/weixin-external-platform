package com.bingkun.weixin.mp.dto.outxmlbuilder;


import com.bingkun.weixin.mp.dto.WxMpXmlOutImageMessage;

/**
 * Created by chenxiaobian 17/1/19
 */
public final class ImageBuilder extends BaseBuilder<ImageBuilder, WxMpXmlOutImageMessage> {

  private String mediaId;

  public ImageBuilder mediaId(String media_id) {
    this.mediaId = media_id;
    return this;
  }

  public WxMpXmlOutImageMessage build() {
    WxMpXmlOutImageMessage m = new WxMpXmlOutImageMessage();
    setCommon(m);
    m.setMediaId(this.mediaId);
    return m;
  }
  
}
