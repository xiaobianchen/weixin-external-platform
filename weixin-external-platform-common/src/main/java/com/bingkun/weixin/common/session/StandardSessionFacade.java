package com.bingkun.weixin.common.session;

import java.util.Enumeration;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public class StandardSessionFacade implements WxSession {

    private WxSession session = null;

    public StandardSessionFacade(StandardSession session) {
        this.session = session;
    }

    public InternalSession getInternalSession() {
        return (InternalSession) this.session;
    }

    @Override
    public Object getAttribute(String name) {
        return this.session.getAttribute(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return this.session.getAttributeNames();
    }

    @Override
    public void setAttribute(String name, Object value) {
        this.session.setAttribute(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        this.session.removeAttribute(name);
    }

    @Override
    public void invalidate() {
        this.session.invalidate();
    }

}
