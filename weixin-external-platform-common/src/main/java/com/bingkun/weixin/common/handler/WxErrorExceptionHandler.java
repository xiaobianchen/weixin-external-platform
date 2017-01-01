package com.bingkun.weixin.common.handler;

import com.bingkun.weixin.common.exception.WxErrorException;

/**
 * Created by chenxiaobian on 17/1/1.
 *
 * 错误处理器
 */
public interface WxErrorExceptionHandler {

    void handle(WxErrorException e);
}
