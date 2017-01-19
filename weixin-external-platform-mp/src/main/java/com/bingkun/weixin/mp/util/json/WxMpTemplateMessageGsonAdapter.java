package com.bingkun.weixin.mp.util.json;

import com.bingkun.weixin.mp.dto.WxMpTemplateData;
import com.bingkun.weixin.mp.dto.WxMpTemplateMessage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class WxMpTemplateMessageGsonAdapter implements JsonSerializer<WxMpTemplateMessage> {

    public JsonElement serialize(WxMpTemplateMessage message, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();
        messageJson.addProperty("touser", message.getToUser());
        messageJson.addProperty("template_id", message.getTemplateId());
        if (message.getUrl() != null) {
            messageJson.addProperty("url", message.getUrl());
        }
        if (message.getTopColor() != null) {
            messageJson.addProperty("topcolor", message.getTopColor());
        }

        JsonObject datas = new JsonObject();
        messageJson.add("data", datas);

        for (WxMpTemplateData data : message.getDatas()) {
            JsonObject dataJson = new JsonObject();
            dataJson.addProperty("value", data.getValue());
            if (data.getColor() != null) {
                dataJson.addProperty("color", data.getColor());
            }
            datas.add(data.getName(), dataJson);
        }

        return messageJson;
    }

}
