
package com.bingkun.weixin.util.json;

import com.bingkun.weixin.bean.WxMpMassTagMessage;
import com.bingkun.weixin.common.constants.WxConsts;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class WxMpMassTagMessageGsonAdapter implements JsonSerializer<WxMpMassTagMessage> {

    @Override
    public JsonElement serialize(WxMpMassTagMessage message, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();

        JsonObject filter = new JsonObject();
        if (message.isSendAll() || null == message.getTagId()) {
            filter.addProperty("is_to_all", true);
        } else {
            filter.addProperty("is_to_all", false);
            filter.addProperty("tag_id", message.getTagId());
        }
        messageJson.add("filter", filter);

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
        messageJson.addProperty("send_ignore_reprint", message.isSendIgnoreReprint() ? 0 : 1);
        return messageJson;
    }

}
