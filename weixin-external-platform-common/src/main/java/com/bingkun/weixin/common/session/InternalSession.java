package com.bingkun.weixin.common.session;

public interface InternalSession {

    WxSession getSession();

    boolean isValid();

    void setValid(boolean isValid);

    String getIdInternal();

    void expire();

    void access();

    void endAccess();

    void setCreationTime(long time);

    void setMaxInactiveInterval(int interval);

    void setId(String id);
}
