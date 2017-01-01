package com.bingkun.weixin.common.exception;

import com.bingkun.weixin.common.dto.result.WxError;

/**
 * Created by chenxiaobian on 17/1/1.
 */
public class WxErrorException extends RuntimeException {
    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(WxError error, Throwable throwable) {
        super(error.toString(), throwable);
        this.error = error;
    }

    public WxErrorException(String msg,Throwable throwable){
        super(msg);
    }

    public WxError getError() {
        return this.error;
    }
}
