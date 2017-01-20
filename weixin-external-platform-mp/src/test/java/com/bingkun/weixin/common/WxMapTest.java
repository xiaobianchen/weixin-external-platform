package com.bingkun.weixin.common;

import com.bingkun.weixin.mp.api.WxMpInMemoryConfigStorage;
import com.bingkun.weixin.mp.api.WxMpService;
import com.bingkun.weixin.mp.api.WxMpServiceImpl;
import com.bingkun.weixin.mp.dto.WxMpCustomMessage;
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

        String openid="o8APSvrnGt0nyw3tCYlEFaTNfzWc";
        WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content("Hello World").build();
        wxMpService.customMessageSend(message);
    }



}
