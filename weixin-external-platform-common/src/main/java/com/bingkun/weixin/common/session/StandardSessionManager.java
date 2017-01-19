package com.bingkun.weixin.common.session;

import com.bingkun.weixin.common.util.res.StringManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by chenxiaobian on 17/1/19
 * 基于内存的session manager
 */
public class StandardSessionManager implements WxSessionManager, InternalSessionManager {

    protected static final StringManager sm = StringManager.getManager(Constants.Package);

    private static final String name = "SessionManagerImpl";
    private final Object maxActiveUpdateLock = new Object();

    /**
     * 后台清理线程是否已经开启
     */
    private final AtomicBoolean backgroundProcessStarted = new AtomicBoolean(false);

    protected Map<String, InternalSession> sessions = new ConcurrentHashMap<>();

    protected int maxActiveSessions = -1;

    protected int rejectedSessions = 0;

    protected int maxInactiveInterval = 30 * 60;

    protected long sessionCounter = 0;

    protected volatile int maxActive = 0;

    protected long processingTime = 0;

    protected int processExpiresFrequency = 6;

    protected int backgroundProcessorDelay = 10;

    private int count = 0;

    @Override
    public WxSession getSession(String sessionId) {
        return getSession(sessionId, true);
    }

    @Override
    public WxSession getSession(String sessionId, boolean create) {
        if (sessionId == null) {
            throw new IllegalStateException
                    (sm.getString("sessionManagerImpl.getSession.ise"));
        }

        InternalSession session = findSession(sessionId);
        if ((session != null) && !session.isValid()) {
            session = null;
        }
        if (session != null) {
            session.access();
            return session.getSession();
        }

        if (!create) {
            return (null);
        }

        session = createSession(sessionId);

        if (session == null) {
            return null;
        }

        session.access();
        return session.getSession();
    }

    @Override
    public void remove(InternalSession session) {
        remove(session, false);
    }

    @Override
    public void remove(InternalSession session, boolean update) {
        if (session.getIdInternal() != null) {
            this.sessions.remove(session.getIdInternal());
        }
    }

    @Override
    public InternalSession findSession(String id) {

        if (id == null)
            return (null);
        return this.sessions.get(id);

    }

    @Override
    public InternalSession createSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalStateException
                    (sm.getString("sessionManagerImpl.createSession.ise"));
        }

        if ((this.maxActiveSessions >= 0) &&
                (getActiveSessions() >= this.maxActiveSessions)) {
            this.rejectedSessions++;
            throw new TooManyActiveSessionsException(
                    sm.getString("sessionManagerImpl.createSession.tmase"),
                    this.maxActiveSessions);
        }

        InternalSession session = createEmptySession();

        // Initialize the properties of the new session and return it
        session.setValid(true);
        session.setCreationTime(System.currentTimeMillis());
        session.setMaxInactiveInterval(this.maxInactiveInterval);
        String id = sessionId;
        session.setId(id);
        this.sessionCounter++;

        return (session);
    }


    @Override
    public int getActiveSessions() {
        return this.sessions.size();
    }

    @Override
    public InternalSession createEmptySession() {
        return (getNewSession());
    }

    protected InternalSession getNewSession() {
        return new StandardSession(this);
    }


    @Override
    public void add(InternalSession session) {

        // 当第一次有session创建的时候，开启session清理线程
        if (!this.backgroundProcessStarted.getAndSet(true)) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // 每秒清理一次
                            Thread.sleep(StandardSessionManager.this.backgroundProcessorDelay * 1000l);
                            backgroundProcess();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            });
            t.setDaemon(true);
            t.start();
        }

        this.sessions.put(session.getIdInternal(), session);
        int size = getActiveSessions();
        if (size > this.maxActive) {
            synchronized (this.maxActiveUpdateLock) {
                if (size > this.maxActive) {
                    this.maxActive = size;
                }
            }
        }

    }

    @Override
    public InternalSession[] findSessions() {

        return this.sessions.values().toArray(new InternalSession[0]);

    }

    @Override
    public void backgroundProcess() {
        this.count = (this.count + 1) % this.processExpiresFrequency;
        if (this.count == 0)
            processExpires();
    }

    public void processExpires() {

        long timeNow = System.currentTimeMillis();
        InternalSession sessions[] = findSessions();
        int expireHere = 0;
    }


    @Override
    public void setMaxInactiveInterval(int interval) {

        this.maxInactiveInterval = interval;

    }

    @Override
    public void setProcessExpiresFrequency(int processExpiresFrequency) {

        if (processExpiresFrequency <= 0) {
            return;
        }

        this.processExpiresFrequency = processExpiresFrequency;
    }

    @Override
    public void setBackgroundProcessorDelay(int backgroundProcessorDelay) {
        this.backgroundProcessorDelay = backgroundProcessorDelay;
    }

    public String getName() {

        return (name);

    }

    @Override
    public void setMaxActiveSessions(int max) {

        this.maxActiveSessions = max;

    }

}
