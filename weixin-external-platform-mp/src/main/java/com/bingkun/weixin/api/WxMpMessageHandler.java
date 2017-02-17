package com.bingkun.weixin.api;

import com.bingkun.weixin.bean.message.WxMpXmlMessage;
import com.bingkun.weixin.bean.message.WxMpXmlOutMessage;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.session.WxSessionManager;

import java.util.Map;

/**
 * 处理微信推送消息的处理器接口
 * <p>
 * Created by chenxiaobian on 2017/2/6.
 */
public interface WxMpMessageHandler {

    /**
     * @param wxMessage
     * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
     * @param wxMpService
     * @param sessionManager
     * @return xml格式的消息，如果在异步规则里处理的话，可以返回null
     */
    WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                             Map<String, Object> context,
                             WxMpService wxMpService,
                             WxSessionManager sessionManager) throws WxErrorException;

}
