package com.bingkun.weixin.common.session;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public interface InternalSessionManager {

    InternalSession findSession(String id);

    InternalSession createSession(String sessionId);

    void remove(InternalSession session);

    void remove(InternalSession session, boolean update);

    void add(InternalSession session);

    int getActiveSessions();

    InternalSession createEmptySession();

    InternalSession[] findSessions();

    void backgroundProcess();

    void setMaxInactiveInterval(int interval);

    void setProcessExpiresFrequency(int processExpiresFrequency);

    void setBackgroundProcessorDelay(int backgroundProcessorDelay);

    void setMaxActiveSessions(int max);

}
