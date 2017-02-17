package com.bingkun.weixin.util.json;

import com.bingkun.weixin.bean.WxMpCard;
import com.bingkun.weixin.common.util.json.GsonHelper;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by chenxiaobian 2017/2/10
 */
public class WxMpCardGsonAdapter implements JsonDeserializer<WxMpCard> {

    @Override
    public WxMpCard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext
            jsonDeserializationContext) throws JsonParseException {
        WxMpCard card = new WxMpCard();
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        card.setCardId(GsonHelper.getString(jsonObject, "card_id"));
        card.setBeginTime(GsonHelper.getLong(jsonObject, "begin_time"));
        card.setEndTime(GsonHelper.getLong(jsonObject, "end_time"));

        return card;
    }

}
