package com.bingkun.weixin.common.handler;

/**
 * Created by chenxiaobian on 17/1/1.
 * 消息重复检查器
 */
public interface WxMessageDuplicateChecker {

    boolean isDuplicate(String messageId);

}
