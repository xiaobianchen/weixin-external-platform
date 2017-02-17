package com.bingkun.weixin.test;

import com.bingkun.weixin.api.WxMpInMemoryConfigStorage;
import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.api.impl.WxMpServiceImpl;
import org.junit.Test;

/**
 * Created by chenxiaobian on 17/1/20.
 */
public class WxMapTest {

    @Test
    public void testMp(){
        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId("wxdd4273d491a1acc6");
        configStorage.setSecret("e2a1cc4b5828f25ed439db4835754c25");
        configStorage.setToken("29359_x");
        configStorage.setAesKey("h4JRaqAMJroTljaP7oQPLbz0WBbbPpKNWcfATdDYBae");

        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);


    }



}
