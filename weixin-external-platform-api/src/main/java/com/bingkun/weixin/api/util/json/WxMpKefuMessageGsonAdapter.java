package com.bingkun.weixin.api.util.json;

import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.common.constants.WxConsts;
import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class WxMpKefuMessageGsonAdapter implements JsonSerializer<WxMpKefuMessage> {

    @Override
    public JsonElement serialize(WxMpKefuMessage message, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();
        messageJson.addProperty("touser", message.getToUser());
        messageJson.addProperty("msgtype", message.getMsgType());

        if (WxConsts.CUSTOM_MSG_TEXT.equals(message.getMsgType())) {
            JsonObject text = new JsonObject();
            text.addProperty("content", message.getContent());
            messageJson.add("text", text);
        }

        if (WxConsts.CUSTOM_MSG_IMAGE.equals(message.getMsgType())) {
            JsonObject image = new JsonObject();
            image.addProperty("media_id", message.getMediaId());
            messageJson.add("image", image);
        }

        if (WxConsts.CUSTOM_MSG_VOICE.equals(message.getMsgType())) {
            JsonObject voice = new JsonObject();
            voice.addProperty("media_id", message.getMediaId());
            messageJson.add("voice", voice);
        }

        if (WxConsts.CUSTOM_MSG_VIDEO.equals(message.getMsgType())) {
            JsonObject video = new JsonObject();
            video.addProperty("media_id", message.getMediaId());
            video.addProperty("thumb_media_id", message.getThumbMediaId());
            video.addProperty("title", message.getTitle());
            video.addProperty("description", message.getDescription());
            messageJson.add("video", video);
        }

        if (WxConsts.CUSTOM_MSG_MUSIC.equals(message.getMsgType())) {
            JsonObject music = new JsonObject();
            music.addProperty("title", message.getTitle());
            music.addProperty("description", message.getDescription());
            music.addProperty("thumb_media_id", message.getThumbMediaId());
            music.addProperty("musicurl", message.getMusicUrl());
            music.addProperty("hqmusicurl", message.getHqMusicUrl());
            messageJson.add("music", music);
        }

        if (WxConsts.CUSTOM_MSG_NEWS.equals(message.getMsgType())) {
            JsonObject newsJsonObject = new JsonObject();
            JsonArray articleJsonArray = new JsonArray();
            for (WxMpKefuMessage.WxArticle article : message.getArticles()) {
                JsonObject articleJson = new JsonObject();
                articleJson.addProperty("title", article.getTitle());
                articleJson.addProperty("description", article.getDescription());
                articleJson.addProperty("url", article.getUrl());
                articleJson.addProperty("picurl", article.getPicUrl());
                articleJsonArray.add(articleJson);
            }
            newsJsonObject.add("articles", articleJsonArray);
            messageJson.add("news", newsJsonObject);
        }

        if (WxConsts.CUSTOM_MSG_MPNEWS.equals(message.getMsgType())) {
            JsonObject json = new JsonObject();
            json.addProperty("media_id", message.getMpNewsMediaId());
            messageJson.add("mpnews", json);
        }

        if (WxConsts.CUSTOM_MSG_WXCARD.equals(message.getMsgType())) {
            JsonObject wxcard = new JsonObject();
            wxcard.addProperty("card_id", message.getCardId());
            messageJson.add("wxcard", wxcard);
        }

        if (StringUtils.isNotBlank(message.getKfAccount())) {
            JsonObject newsJsonObject = new JsonObject();
            newsJsonObject.addProperty("kf_account", message.getKfAccount());
            messageJson.add("customservice", newsJsonObject);
        }

        return messageJson;
    }

}
