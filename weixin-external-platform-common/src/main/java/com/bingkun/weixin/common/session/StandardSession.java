package com.bingkun.weixin.common.session;


import com.bingkun.weixin.common.util.res.StringManager;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class StandardSession implements WxSession, InternalSession {

    protected static final StringManager sm = StringManager.getManager(Constants.Package);

    protected static final String EMPTY_ARRAY[] = new String[0];

    protected Map<String, Object> attributes = new ConcurrentHashMap<>();

    protected String id = null;

    protected volatile boolean isValid = false;

    protected transient volatile boolean expiring = false;

    protected transient InternalSessionManager manager = null;

    protected long creationTime = 0L;

    protected volatile long thisAccessedTime = this.creationTime;

    protected int maxInactiveInterval = 30 * 60;

    protected transient StandardSessionFacade facade = null;

    protected transient AtomicInteger accessCount = null;

    public StandardSession(InternalSessionManager manager) {
        this.manager = manager;
        this.accessCount = new AtomicInteger();
    }

    @Override
    public Object getAttribute(String name) {

        if (!isValidInternal())
            throw new IllegalStateException
                    (sm.getString("sessionImpl.getAttribute.ise"));

        if (name == null) return null;

        return (this.attributes.get(name));
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        if (!isValidInternal())
            throw new IllegalStateException
                    (sm.getString("sessionImpl.getAttributeNames.ise"));

        Set<String> names = new HashSet<>();
        names.addAll(this.attributes.keySet());
        return Collections.enumeration(names);
    }

    @Override
    public void setAttribute(String name, Object value) {
        if (name == null)
            throw new IllegalArgumentException
                    (sm.getString("sessionImpl.setAttribute.namenull"));

        if (value == null) {
            removeAttribute(name);
            return;
        }

        if (!isValidInternal())
            throw new IllegalStateException(sm.getString(
                    "sessionImpl.setAttribute.ise", getIdInternal()));

        this.attributes.put(name, value);

    }

    @Override
    public void removeAttribute(String name) {
        removeAttributeInternal(name);
    }

    @Override
    public void invalidate() {
        if (!isValidInternal())
            throw new IllegalStateException
                    (sm.getString("sessionImpl.invalidate.ise"));

        expire();

    }

    @Override
    public WxSession getSession() {

        if (this.facade == null) {
            this.facade = new StandardSessionFacade(this);
        }
        return (this.facade);

    }

    protected boolean isValidInternal() {
        return this.isValid;
    }

    @Override
    public boolean isValid() {
        if (!this.isValid) {
            return false;
        }

        if (this.expiring) {
            return true;
        }

        if (this.accessCount.get() > 0) {
            return true;
        }

        if (this.maxInactiveInterval > 0) {
            long timeNow = System.currentTimeMillis();
            int timeIdle;
            timeIdle = (int) ((timeNow - this.thisAccessedTime) / 1000L);
            if (timeIdle >= this.maxInactiveInterval) {
                expire();
            }
        }

        return this.isValid;
    }

    @Override
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String getIdInternal() {
        return (this.id);
    }

    protected void removeAttributeInternal(String name) {
        if (name == null) return;
        this.attributes.remove(name);

    }

    @Override
    public void expire() {
        if (!this.isValid)
            return;

        synchronized (this) {
            if (this.expiring || !this.isValid)
                return;

            if (this.manager == null)
                return;

            this.expiring = true;
            this.accessCount.set(0);
            this.manager.remove(this, true);

            setValid(false);
            this.expiring = false;

            String keys[] = keys();
            for (int i = 0; i < keys.length; i++) {
                removeAttributeInternal(keys[i]);
            }
        }
    }


    @Override
    public void access() {
        this.thisAccessedTime = System.currentTimeMillis();
        this.accessCount.incrementAndGet();
    }


    @Override
    public void endAccess() {
        this.thisAccessedTime = System.currentTimeMillis();
        this.accessCount.decrementAndGet();
    }

    @Override
    public void setCreationTime(long time) {
        this.creationTime = time;
        this.thisAccessedTime = time;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
        this.maxInactiveInterval = interval;
    }


    @Override
    public void setId(String id) {
        if ((this.id != null) && (this.manager != null))
            this.manager.remove(this);

        this.id = id;

        if (this.manager != null)
            this.manager.add(this);
    }

    protected String[] keys() {
        return this.attributes.keySet().toArray(EMPTY_ARRAY);
    }
}
