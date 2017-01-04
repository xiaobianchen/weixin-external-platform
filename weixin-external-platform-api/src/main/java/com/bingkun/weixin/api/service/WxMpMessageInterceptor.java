package com.bingkun.weixin.api.service;


import com.bingkun.weixin.api.dto.message.WxMpXmlMessage;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.session.WxSessionManager;

import java.util.Map;

/**
 * Created by chenxiaobian on 2017/1/2.
 *
 * 微信消息拦截器，可以用来做验证
 *
 */
public interface WxMpMessageInterceptor {

    /**
     * 拦截微信消息
     *
     * @param wxMessage
     * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
     * @param wxMpService
     * @param sessionManager
     * @return true代表OK，false代表不OK
     */
    boolean intercept(WxMpXmlMessage wxMessage,
                      Map<String, Object> context,
                      WxMpService wxMpService,
                      WxSessionManager sessionManager) throws WxErrorException;

}
