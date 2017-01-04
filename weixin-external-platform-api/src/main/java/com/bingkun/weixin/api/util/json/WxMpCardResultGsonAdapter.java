package com.bingkun.weixin.api.util.json;

import com.bingkun.weixin.api.dto.WxMpCard;
import com.bingkun.weixin.api.dto.result.WxMpCardResult;
import com.bingkun.weixin.common.util.json.GsonHelper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class WxMpCardResultGsonAdapter implements JsonDeserializer<WxMpCardResult> {
    @Override
    public WxMpCardResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxMpCardResult cardResult = new WxMpCardResult();
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        cardResult.setOpenId(GsonHelper.getString(jsonObject, "openid"));
        cardResult.setErrorCode(GsonHelper.getString(jsonObject, "errcode"));
        cardResult.setErrorMsg(GsonHelper.getString(jsonObject, "errmsg"));
        cardResult.setCanConsume(GsonHelper.getBoolean(jsonObject, "can_consume"));
        cardResult.setUserCardStatus(GsonHelper.getString(jsonObject, "user_card_status"));

        WxMpCard card = WxMpGsonBuilder.INSTANCE.create().fromJson(jsonObject.get("card"),
                new TypeToken<WxMpCard>() {
                }.getType());

        cardResult.setCard(card);

        return cardResult;
    }
}
