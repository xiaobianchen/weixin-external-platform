package com.bingkun.weixin.api.util.json;

import com.bingkun.weixin.api.dto.WxMpMassOpenIdsMessage;
import com.bingkun.weixin.common.constants.WxConsts;
import com.google.gson.*;

import java.lang.reflect.Type;

public class WxMpMassOpenIdsMessageGsonAdapter implements JsonSerializer<WxMpMassOpenIdsMessage> {

    @Override
    public JsonElement serialize(WxMpMassOpenIdsMessage message, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();

        JsonArray toUsers = new JsonArray();
        for (String openId : message.getToUsers()) {
            toUsers.add(new JsonPrimitive(openId));
        }
        messageJson.add("touser", toUsers);

        if (WxConsts.MASS_MSG_NEWS.equals(message.getMsgType())) {
            JsonObject sub = new JsonObject();
            sub.addProperty("media_id", message.getMediaId());
            messageJson.add(WxConsts.MASS_MSG_NEWS, sub);
        }
        if (WxConsts.MASS_MSG_TEXT.equals(message.getMsgType())) {
            JsonObject sub = new JsonObject();
            sub.addProperty("content", message.getContent());
            messageJson.add(WxConsts.MASS_MSG_TEXT, sub);
        }
        if (WxConsts.MASS_MSG_VOICE.equals(message.getMsgType())) {
            JsonObject sub = new JsonObject();
            sub.addProperty("media_id", message.getMediaId());
            messageJson.add(WxConsts.MASS_MSG_VOICE, sub);
        }
        if (WxConsts.MASS_MSG_IMAGE.equals(message.getMsgType())) {
            JsonObject sub = new JsonObject();
            sub.addProperty("media_id", message.getMediaId());
            messageJson.add(WxConsts.MASS_MSG_IMAGE, sub);
        }
        if (WxConsts.MASS_MSG_VIDEO.equals(message.getMsgType())) {
            JsonObject sub = new JsonObject();
            sub.addProperty("media_id", message.getMediaId());
            messageJson.add(WxConsts.MASS_MSG_VIDEO, sub);
        }
        messageJson.addProperty("msgtype", message.getMsgType());
        return messageJson;
    }

}
