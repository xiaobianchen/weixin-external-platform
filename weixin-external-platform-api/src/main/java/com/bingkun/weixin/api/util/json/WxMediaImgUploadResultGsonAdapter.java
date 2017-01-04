package com.bingkun.weixin.api.util.json;

import com.bingkun.weixin.api.dto.material.WxMediaImgUploadResult;
import com.bingkun.weixin.common.util.json.GsonHelper;
import com.google.gson.*;

import java.lang.reflect.Type;


public class WxMediaImgUploadResultGsonAdapter implements JsonDeserializer<WxMediaImgUploadResult> {
    @Override
    public WxMediaImgUploadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        WxMediaImgUploadResult wxMediaImgUploadResult = new WxMediaImgUploadResult();
        JsonObject jsonObject = json.getAsJsonObject();
        if (null != jsonObject.get("url") && !jsonObject.get("url").isJsonNull()) {
            wxMediaImgUploadResult.setUrl(GsonHelper.getAsString(jsonObject.get("url")));
        }
        return wxMediaImgUploadResult;
    }
}
