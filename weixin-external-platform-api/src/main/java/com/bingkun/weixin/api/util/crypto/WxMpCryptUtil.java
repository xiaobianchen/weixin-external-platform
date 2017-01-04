package com.bingkun.weixin.api.util.crypto;

import com.bingkun.weixin.api.service.WxMpConfigStorage;
import com.bingkun.weixin.common.util.crypto.WxCryptUtil;
import org.apache.commons.codec.binary.Base64;

public class WxMpCryptUtil extends WxCryptUtil {

    /**
     * 构造函数
     *
     * @param wxMpConfigStorage
     */
    public WxMpCryptUtil(WxMpConfigStorage wxMpConfigStorage) {
        String encodingAesKey = wxMpConfigStorage.getAesKey();
        String token = wxMpConfigStorage.getToken();
        String appId = wxMpConfigStorage.getAppId();

        this.token = token;
        this.appidOrCorpid = appId;
        this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
    }

}
