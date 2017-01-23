package com.bingkun.weixin.common.session;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public class TooManyActiveSessionsException extends IllegalStateException {

    private final int maxActiveSessions;

    public TooManyActiveSessionsException(String message, int maxActive) {
        super(message);
        this.maxActiveSessions = maxActive;
    }

    public int getMaxActiveSessions() {
        return this.maxActiveSessions;
    }
}
