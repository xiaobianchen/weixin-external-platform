package com.bingkun.weixin.common.util;


import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.handler.WxErrorExceptionHandler;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public class LogExceptionHandler implements WxErrorExceptionHandler {

  @Override
  public void handle(WxErrorException e) {
      throw new WxErrorException("处理异常",e);
  }

}
