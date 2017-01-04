package com.bingkun.weixin.common.session;

public class TooManyActiveSessionsException extends IllegalStateException {

    private final int maxActiveSessions;

    public TooManyActiveSessionsException(String message,
                                          int maxActive) {
        super(message);

        this.maxActiveSessions = maxActive;
    }

    public int getMaxActiveSessions() {
        return this.maxActiveSessions;
    }
}
