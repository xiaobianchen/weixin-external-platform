
package com.bingkun.weixin.util.json;

import com.bingkun.weixin.bean.material.WxMpMaterialFileBatchGetResult;
import com.bingkun.weixin.common.util.json.GsonHelper;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class WxMpMaterialFileBatchGetGsonItemAdapter implements JsonDeserializer<WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem> {

    @Override
    public WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem wxMaterialFileBatchGetNewsItem = new WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem();
        JsonObject json = jsonElement.getAsJsonObject();
        if (json.get("media_id") != null && !json.get("media_id").isJsonNull()) {
            wxMaterialFileBatchGetNewsItem.setMediaId(GsonHelper.getAsString(json.get("media_id")));
        }
        if (json.get("update_time") != null && !json.get("update_time").isJsonNull()) {
            wxMaterialFileBatchGetNewsItem.setUpdateTime(new Date(1000 * GsonHelper.getAsLong(json.get("update_time"))));
        }
        if (json.get("name") != null && !json.get("name").isJsonNull()) {
            wxMaterialFileBatchGetNewsItem.setName(GsonHelper.getAsString(json.get("name")));
        }
        if (json.get("url") != null && !json.get("url").isJsonNull()) {
            wxMaterialFileBatchGetNewsItem.setUrl(GsonHelper.getAsString(json.get("url")));
        }
        return wxMaterialFileBatchGetNewsItem;
    }
}
