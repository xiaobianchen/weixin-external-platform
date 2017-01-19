package com.bingkun.weixin.mp.api;

import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.session.WxSessionManager;
import com.bingkun.weixin.mp.dto.WxMpXmlMessage;
import com.bingkun.weixin.mp.dto.WxMpXmlOutMessage;

import java.util.Map;

/**
 * Created by chenxiaobian 17/1/19
 * 处理微信推送消息的处理器接口
 */
public interface WxMpMessageHandler {

    /**
     * @param wxMessage
     * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
     * @param wxMpService
     * @param sessionManager
     * @return xml格式的消息，如果在异步规则里处理的话，可以返回null
     */
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context,
                                    WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException;
}
