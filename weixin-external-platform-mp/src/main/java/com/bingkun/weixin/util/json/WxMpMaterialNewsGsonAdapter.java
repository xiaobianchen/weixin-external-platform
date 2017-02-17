
package com.bingkun.weixin.util.json;

import com.bingkun.weixin.bean.material.WxMpMaterialNews;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by chenxiaobian 2017/2/16
 */
public class WxMpMaterialNewsGsonAdapter implements JsonSerializer<WxMpMaterialNews>, JsonDeserializer<WxMpMaterialNews> {

    @Override
    public JsonElement serialize(WxMpMaterialNews wxMpMaterialNews, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject newsJson = new JsonObject();

        JsonArray articleJsonArray = new JsonArray();
        for (WxMpMaterialNews.WxMpMaterialNewsArticle article : wxMpMaterialNews.getArticles()) {
            JsonObject articleJson = WxMpGsonBuilder.create().toJsonTree(article, WxMpMaterialNews.WxMpMaterialNewsArticle.class).getAsJsonObject();
            articleJsonArray.add(articleJson);
        }
        newsJson.add("articles", articleJsonArray);

        return newsJson;
    }

    @Override
    public WxMpMaterialNews deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxMpMaterialNews wxMpMaterialNews = new WxMpMaterialNews();
        JsonObject json = jsonElement.getAsJsonObject();
        if (json.get("news_item") != null && !json.get("news_item").isJsonNull()) {
            JsonArray articles = json.getAsJsonArray("news_item");
            for (JsonElement article1 : articles) {
                JsonObject articleInfo = article1.getAsJsonObject();
                WxMpMaterialNews.WxMpMaterialNewsArticle article = WxMpGsonBuilder.create().fromJson(articleInfo, WxMpMaterialNews.WxMpMaterialNewsArticle.class);
                wxMpMaterialNews.addArticle(article);
            }
        }
        return wxMpMaterialNews;
    }
}
