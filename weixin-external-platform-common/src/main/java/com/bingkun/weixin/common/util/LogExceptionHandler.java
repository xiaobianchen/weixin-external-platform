package com.bingkun.weixin.common.util;


import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.handler.WxErrorExceptionHandler;

public class LogExceptionHandler implements WxErrorExceptionHandler {

  @Override
  public void handle(WxErrorException e) {
      throw new WxErrorException("处理异常",e);
  }

}
