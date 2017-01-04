
package com.bingkun.weixin.api.util.json;

import com.bingkun.weixin.api.dto.material.WxMpMaterialNews;
import com.bingkun.weixin.common.util.json.GsonHelper;
import com.google.gson.*;

import java.lang.reflect.Type;

public class WxMpMaterialNewsArticleGsonAdapter implements JsonSerializer<WxMpMaterialNews.WxMpMaterialNewsArticle>, JsonDeserializer<WxMpMaterialNews.WxMpMaterialNewsArticle> {

    @Override
    public JsonElement serialize(WxMpMaterialNews.WxMpMaterialNewsArticle article, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject articleJson = new JsonObject();

        articleJson.addProperty("thumb_media_id", article.getThumbMediaId());
        articleJson.addProperty("thumb_url", article.getThumbUrl());
        articleJson.addProperty("title", article.getTitle());
        articleJson.addProperty("content", article.getContent());
        if (null != article.getAuthor()) {
            articleJson.addProperty("author", article.getAuthor());
        }
        if (null != article.getContentSourceUrl()) {
            articleJson.addProperty("content_source_url", article.getContentSourceUrl());
        }
        if (null != article.getDigest()) {
            articleJson.addProperty("digest", article.getDigest());
        }
        articleJson.addProperty("show_cover_pic", article.isShowCoverPic() ? "1" : "0");
        if (null != article.getUrl()) {
            articleJson.addProperty("url", article.getUrl());
        }
        return articleJson;
    }

    @Override
    public WxMpMaterialNews.WxMpMaterialNewsArticle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject articleInfo = jsonElement.getAsJsonObject();
        WxMpMaterialNews.WxMpMaterialNewsArticle article = new WxMpMaterialNews.WxMpMaterialNewsArticle();

        JsonElement title = articleInfo.get("title");
        if (title != null && !title.isJsonNull()) {
            article.setTitle(GsonHelper.getAsString(title));
        }
        JsonElement content = articleInfo.get("content");
        if (content != null && !content.isJsonNull()) {
            article.setContent(GsonHelper.getAsString(content));
        }
        JsonElement contentSourceUrl = articleInfo.get("content_source_url");
        if (contentSourceUrl != null && !contentSourceUrl.isJsonNull()) {
            article.setContentSourceUrl(GsonHelper.getAsString(contentSourceUrl));
        }
        JsonElement author = articleInfo.get("author");
        if (author != null && !author.isJsonNull()) {
            article.setAuthor(GsonHelper.getAsString(author));
        }
        JsonElement digest = articleInfo.get("digest");
        if (digest != null && !digest.isJsonNull()) {
            article.setDigest(GsonHelper.getAsString(digest));
        }
        JsonElement thumbMediaId = articleInfo.get("thumb_media_id");
        if (thumbMediaId != null && !thumbMediaId.isJsonNull()) {
            article.setThumbMediaId(GsonHelper.getAsString(thumbMediaId));
        }
        JsonElement thumbUrl = articleInfo.get("thumb_url");
        if (thumbUrl != null && !thumbUrl.isJsonNull()) {
            article.setThumbUrl(GsonHelper.getAsString(thumbUrl));
        }
        JsonElement showCoverPic = articleInfo.get("show_cover_pic");
        if (showCoverPic != null && !showCoverPic.isJsonNull()) {
            article.setShowCoverPic(GsonHelper.getAsBoolean(showCoverPic));
        }
        JsonElement url = articleInfo.get("url");
        if (url != null && !url.isJsonNull()) {
            article.setUrl(GsonHelper.getAsString(url));
        }
        return article;
    }
}
