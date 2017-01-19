package com.bingkun.weixin.mp.util.json;

import com.bingkun.weixin.common.util.json.GsonHelper;
import com.bingkun.weixin.mp.dto.result.WxMpUserList;
import com.google.gson.*;

import java.lang.reflect.Type;

public class WxUserListGsonAdapter implements JsonDeserializer<WxMpUserList> {

    public WxMpUserList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        WxMpUserList wxMpUserList = new WxMpUserList();
        wxMpUserList.setTotal(GsonHelper.getInteger(o, "total"));
        wxMpUserList.setCount(GsonHelper.getInteger(o, "count"));
        wxMpUserList.setNextOpenId(GsonHelper.getString(o, "next_openid"));

        if (o.get("data") != null && !o.get("data").isJsonNull() && !o.get("data").getAsJsonObject().get("openid").isJsonNull()) {
            JsonArray data = o.get("data").getAsJsonObject().get("openid").getAsJsonArray();
            for (int i = 0; i < data.size(); i++) {
                wxMpUserList.getOpenIds().add(GsonHelper.getAsString(data.get(i)));
            }
        }
        return wxMpUserList;
    }

}
