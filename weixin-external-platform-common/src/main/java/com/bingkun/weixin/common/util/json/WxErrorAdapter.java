package com.bingkun.weixin.common.util.json;

import com.bingkun.weixin.common.dto.result.WxError;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by chenxiaobian on 17/1/1.
 */
public class WxErrorAdapter implements JsonDeserializer<WxError> {

    @Override
    public WxError deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        WxError wxError = new WxError();
        JsonObject wxErrorJsonObject = json.getAsJsonObject();

        if (wxErrorJsonObject.get("errcode") != null && !wxErrorJsonObject.get("errcode").isJsonNull()) {
            wxError.setErrorCode(GsonHelper.getAsPrimitiveInt(wxErrorJsonObject.get("errcode")));
        }
        if (wxErrorJsonObject.get("errmsg") != null && !wxErrorJsonObject.get("errmsg").isJsonNull()) {
            wxError.setErrorMsg(GsonHelper.getAsString(wxErrorJsonObject.get("errmsg")));
        }
        wxError.setJson(json.toString());
        return wxError;
    }

}
