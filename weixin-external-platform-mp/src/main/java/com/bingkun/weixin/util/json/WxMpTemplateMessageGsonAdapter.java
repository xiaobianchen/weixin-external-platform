
package com.bingkun.weixin.util.json;

import com.bingkun.weixin.bean.template.WxMpTemplateData;
import com.bingkun.weixin.bean.template.WxMpTemplateMessage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by chenxiaobian on 2017/216
 */
public class WxMpTemplateMessageGsonAdapter implements JsonSerializer<WxMpTemplateMessage> {

    @Override
    public JsonElement serialize(WxMpTemplateMessage message, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();
        messageJson.addProperty("touser", message.getToUser());
        messageJson.addProperty("template_id", message.getTemplateId());
        if (message.getUrl() != null) {
            messageJson.addProperty("url", message.getUrl());
        }

        JsonObject data = new JsonObject();
        messageJson.add("data", data);

        for (WxMpTemplateData datum : message.getData()) {
            JsonObject dataJson = new JsonObject();
            dataJson.addProperty("value", datum.getValue());
            if (datum.getColor() != null) {
                dataJson.addProperty("color", datum.getColor());
            }
            data.add(datum.getName(), dataJson);
        }

        return messageJson;
    }

}
