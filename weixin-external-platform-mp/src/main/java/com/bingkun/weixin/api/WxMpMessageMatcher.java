package com.bingkun.weixin.api;

import com.bingkun.weixin.bean.message.WxMpXmlMessage;

/**
 * Created by chenxiaobian on 2017/2/6.
 * 消息匹配器，用在消息路由的时候
 */
public interface WxMpMessageMatcher {

  /**
   * 消息是否匹配某种模式
   * @param message
   */
  boolean match(WxMpXmlMessage message);

}
