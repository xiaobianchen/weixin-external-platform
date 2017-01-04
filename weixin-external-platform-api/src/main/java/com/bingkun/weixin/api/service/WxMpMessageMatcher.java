package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.message.WxMpXmlMessage;

/**
 * Created by chenxiaobian on 2017/1/2.
 * 消息匹配器，用在消息路由的时候
 */
public interface WxMpMessageMatcher {

  /**
   *
   * 消息是否匹配某种模式
   * @param message
   */
  boolean match(WxMpXmlMessage message);

}
