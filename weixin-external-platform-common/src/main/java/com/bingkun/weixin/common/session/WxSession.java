package com.bingkun.weixin.common.session;

import java.util.Enumeration;

/**
 * Created by chenxiaobian 17/1/19
 */
public interface WxSession {

    Object getAttribute(String name);

    Enumeration<String> getAttributeNames();

    void setAttribute(String name, Object value);

    void removeAttribute(String name);

    void invalidate();

}
