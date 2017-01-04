package com.bingkun.weixin.common.handler;

/**
 * Created by chenxiaobian on 17/1/1.
 *
 * 消息重复检查器
 * 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次
 */
public interface WxMessageDuplicateChecker {

    boolean isDuplicate(String messageId);

}
