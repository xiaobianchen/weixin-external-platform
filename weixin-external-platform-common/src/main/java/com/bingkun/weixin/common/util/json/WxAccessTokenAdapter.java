package com.bingkun.weixin.common.util.json;

import com.bingkun.weixin.common.dto.WxAccessToken;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by chenxiaobian on 16/10/19.
 */
public class WxAccessTokenAdapter implements JsonDeserializer<WxAccessToken> {

    @Override
    public WxAccessToken deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        WxAccessToken accessToken = new WxAccessToken();
        JsonObject accessTokenJsonObject = json.getAsJsonObject();

        if (accessTokenJsonObject.get("access_token") != null && !accessTokenJsonObject.get("access_token").isJsonNull()) {
            accessToken.setAccessToken(GsonHelper.getAsString(accessTokenJsonObject.get("access_token")));
        }
        if (accessTokenJsonObject.get("expires_in") != null && !accessTokenJsonObject.get("expires_in").isJsonNull()) {
            accessToken.setExpiresIn(GsonHelper.getAsPrimitiveInt(accessTokenJsonObject.get("expires_in")));
        }
        return accessToken;
    }

}
