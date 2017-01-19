package com.bingkun.weixin.mp.util.json;

import com.bingkun.weixin.common.util.json.GsonHelper;
import com.bingkun.weixin.mp.dto.result.WxMpUserSummary;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class WxMpUserSummaryGsonAdapter implements JsonDeserializer<WxMpUserSummary> {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public WxMpUserSummary deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxMpUserSummary summary = new WxMpUserSummary();
        JsonObject summaryJsonObject = json.getAsJsonObject();

        try {
            String refDate = GsonHelper.getString(summaryJsonObject, "ref_date");
            if (refDate != null) {
                summary.setRefDate(SIMPLE_DATE_FORMAT.parse(refDate));
            }
            summary.setUserSource(GsonHelper.getInteger(summaryJsonObject, "user_source"));
            summary.setNewUser(GsonHelper.getInteger(summaryJsonObject, "new_user"));
            summary.setCancelUser(GsonHelper.getInteger(summaryJsonObject, "cancel_user"));
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }

        return summary;
    }

}
