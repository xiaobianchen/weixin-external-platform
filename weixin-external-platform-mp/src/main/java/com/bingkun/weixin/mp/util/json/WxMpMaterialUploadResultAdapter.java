
package com.bingkun.weixin.mp.util.json;

import com.bingkun.weixin.common.util.json.GsonHelper;
import com.bingkun.weixin.mp.dto.result.WxMpMaterialUploadResult;
import com.google.gson.*;

import java.lang.reflect.Type;


public class WxMpMaterialUploadResultAdapter implements JsonDeserializer<WxMpMaterialUploadResult> {

    public WxMpMaterialUploadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        WxMpMaterialUploadResult uploadResult = new WxMpMaterialUploadResult();
        JsonObject uploadResultJsonObject = json.getAsJsonObject();

        if (uploadResultJsonObject.get("url") != null && !uploadResultJsonObject.get("url").isJsonNull()) {
            uploadResult.setUrl(GsonHelper.getAsString(uploadResultJsonObject.get("url")));
        }
        if (uploadResultJsonObject.get("media_id") != null && !uploadResultJsonObject.get("media_id").isJsonNull()) {
            uploadResult.setMediaId(GsonHelper.getAsString(uploadResultJsonObject.get("media_id")));
        }
        return uploadResult;
    }

}
