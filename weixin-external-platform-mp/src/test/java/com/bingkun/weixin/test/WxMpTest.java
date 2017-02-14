package com.bingkun.weixin.test;

import com.bingkun.weixin.common.dto.menu.WxMenu;
import com.bingkun.weixin.mp.api.WxMpInMemoryConfigStorage;
import com.bingkun.weixin.mp.api.WxMpService;
import com.bingkun.weixin.mp.api.WxMpServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chenxiaobian on 17/2/10.
 */
public class WxMpTest {

    private WxMpService wxMpService;

    @Before
    public void init(){
        wxMpService = new WxMpServiceImpl();

        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxdd4273d491a1acc6"); // 设置微信公众号的appid
        config.setSecret("e2a1cc4b5828f25ed439db4835754c25"); // 设置微信公众号的app corpSecret
        config.setToken("29359_x"); // 设置微信公众号的token
        config.setAesKey("h4JRaqAMJroTljaP7oQPLbz0WBbbPpKNWcfATdDYBae"); // 设置微信公众号的EncodingAESKey
        wxMpService.setWxMpConfigStorage(config);

    }

    @Test
    public void testCheckSignature(){
        boolean isCorrect =  wxMpService.checkSignature("1486686893","998729778","c63f0814676c023a2a1b704f782a9400604aaa8c");
        System.out.println(isCorrect);
    }

    @Test
    public void testGetAccessToken(){
        String accessToken = wxMpService.getAccessToken();
        System.out.println(accessToken);
    }

    @Test
    public void testGetMenu(){
        WxMenu wxMenu = wxMpService.menuGet(wxMpService.getAccessToken());
        System.out.println(wxMenu);
    }
}
