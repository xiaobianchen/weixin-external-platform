package com.bingkun.weixin.common.util.json;

import com.bingkun.weixin.common.dto.WxAccessToken;
import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.dto.result.WxMediaUploadResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public class WxGsonBuilder {

    public static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.registerTypeAdapter(WxAccessToken.class, new WxAccessTokenAdapter());
        INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
        INSTANCE.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }

}
