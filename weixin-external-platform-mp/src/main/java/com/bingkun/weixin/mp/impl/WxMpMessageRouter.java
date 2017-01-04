package com.bingkun.weixin.mp.impl;

import com.bingkun.weixin.api.dto.message.WxMpXmlMessage;
import com.bingkun.weixin.api.dto.message.WxMpXmlOutMessage;
import com.bingkun.weixin.api.service.WxMpService;
import com.bingkun.weixin.common.handler.WxErrorExceptionHandler;
import com.bingkun.weixin.common.handler.WxMessageDuplicateChecker;
import com.bingkun.weixin.common.handler.WxMessageInMemoryDuplicateChecker;
import com.bingkun.weixin.common.session.InternalSession;
import com.bingkun.weixin.common.session.InternalSessionManager;
import com.bingkun.weixin.common.session.StandardSessionManager;
import com.bingkun.weixin.common.session.WxSessionManager;
import com.bingkun.weixin.common.util.LogExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 微信消息路由器，通过代码化的配置，把来自微信的消息交给handler处理
 */
public class WxMpMessageRouter {

    private static final int DEFAULT_THREAD_POOL_SIZE = 100;

    private final List<WxMpMessageRouterRule> rules = new ArrayList<>();

    private final com.bingkun.weixin.api.service.WxMpService wxMpService;

    private ExecutorService executorService;

    private WxMessageDuplicateChecker messageDuplicateChecker;

    private WxSessionManager sessionManager;

    private WxErrorExceptionHandler exceptionHandler;

    public WxMpMessageRouter(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
        this.executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);
        this.messageDuplicateChecker = new WxMessageInMemoryDuplicateChecker();
        this.sessionManager = new StandardSessionManager();
        this.exceptionHandler = new LogExceptionHandler();
    }

    /**
     * <pre>
     * 设置自定义的 {@link ExecutorService}
     * 如果不调用该方法，默认使用 Executors.newFixedThreadPool(100)
     * </pre>
     *
     * @param executorService
     */
    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void setMessageDuplicateChecker(WxMessageDuplicateChecker messageDuplicateChecker) {
        this.messageDuplicateChecker = messageDuplicateChecker;
    }


    public void setSessionManager(WxSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setExceptionHandler(WxErrorExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    List<WxMpMessageRouterRule> getRules() {
        return this.rules;
    }

    /**
     * 开始一个新的Route规则
     */
    public WxMpMessageRouterRule rule() {
        return new WxMpMessageRouterRule(this);
    }

    /**
     * 处理微信消息
     *
     * @param wxMessage
     */
    public WxMpXmlOutMessage route(final WxMpXmlMessage wxMessage) {
        if (isDuplicateMessage(wxMessage)) {
            // 如果是重复消息，那么就不做处理
            return null;
        }

        final List<WxMpMessageRouterRule> matchRules = new ArrayList<>();
        // 收集匹配的规则
        for (final WxMpMessageRouterRule rule : this.rules) {
            if (rule.test(wxMessage)) {
                matchRules.add(rule);
                if (!rule.isReEnter()) {
                    break;
                }
            }
        }

        if (matchRules.size() == 0) {
            return null;
        }

        WxMpXmlOutMessage res = null;
        final List<Future<?>> futures = new ArrayList<>();
        for (final WxMpMessageRouterRule rule : matchRules) {
            // 返回最后一个非异步的rule的执行结果
            if (rule.isAsync()) {
                futures.add(
                        this.executorService.submit(new Runnable() {
                            @Override
                            public void run() {
                                rule.service(wxMessage, WxMpMessageRouter.this.wxMpService, WxMpMessageRouter.this.sessionManager, WxMpMessageRouter.this.exceptionHandler);
                            }
                        })
                );
            } else {
                res = rule.service(wxMessage, this.wxMpService, this.sessionManager, this.exceptionHandler);
                // 在同步操作结束，session访问结束
                sessionEndAccess(wxMessage);
            }
        }

        if (futures.size() > 0) {
            this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (Future<?> future : futures) {
                        try {
                            future.get();
                            // 异步操作结束，session访问结束
                            sessionEndAccess(wxMessage);
                        } catch (InterruptedException e) {
                        } catch (ExecutionException e) {
                        }
                    }
                }
            });
        }
        return res;
    }

    protected boolean isDuplicateMessage(WxMpXmlMessage wxMessage) {

        StringBuffer messageId = new StringBuffer();
        if (wxMessage.getMsgId() == null) {
            messageId.append(wxMessage.getCreateTime())
                    .append("-").append(wxMessage.getFromUser())
                    .append("-").append(wxMessage.getEventKey() == null ? "" : wxMessage.getEventKey())
                    .append("-").append(wxMessage.getEvent() == null ? "" : wxMessage.getEvent())
            ;
        } else {
            messageId.append(wxMessage.getMsgId());
        }

        return this.messageDuplicateChecker.isDuplicate(messageId.toString());

    }

    /**
     * 对session的访问结束
     *
     * @param wxMessage
     */
    protected void sessionEndAccess(WxMpXmlMessage wxMessage) {

        InternalSession session = ((InternalSessionManager) this.sessionManager).findSession(wxMessage.getFromUser());
        if (session != null) {
            session.endAccess();
        }

    }
}
