package com.bingkun.weixin.api.impl;

import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.api.WxMpUserTagService;
import com.bingkun.weixin.bean.tag.WxTagListUser;
import com.bingkun.weixin.bean.tag.WxUserTag;
import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/4.
 */
public class WxMpUserTagServiceImpl implements WxMpUserTagService {
    private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/tags";

    private WxMpService wxMpService;

    public WxMpUserTagServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxUserTag tagCreate(String name) throws WxErrorException {
        String url = API_URL_PREFIX + "/create";
        JsonObject json = new JsonObject();
        JsonObject tagJson = new JsonObject();
        tagJson.addProperty("name", name);
        json.add("tag", tagJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        return WxUserTag.fromJson(responseContent);
    }

    @Override
    public List<WxUserTag> tagGet() throws WxErrorException {
        String url = API_URL_PREFIX + "/get";

        String responseContent = this.wxMpService.get(url, null);
        return WxUserTag.listFromJson(responseContent);
    }

    @Override
    public Boolean tagUpdate(Long id, String name) throws WxErrorException {
        String url = API_URL_PREFIX + "/update";

        JsonObject json = new JsonObject();
        JsonObject tagJson = new JsonObject();
        tagJson.addProperty("id", id);
        tagJson.addProperty("name", name);
        json.add("tag", tagJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public Boolean tagDelete(Long id) throws WxErrorException {
        String url = API_URL_PREFIX + "/delete";

        JsonObject json = new JsonObject();
        JsonObject tagJson = new JsonObject();
        tagJson.addProperty("id", id);
        json.add("tag", tagJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public WxTagListUser tagListUser(Long tagId, String nextOpenid)
            throws WxErrorException {
        String url = "https://api.weixin.qq.com/cgi-bin/user/tag/get";

        JsonObject json = new JsonObject();
        json.addProperty("tagid", tagId);
        json.addProperty("next_openid", StringUtils.trimToEmpty(nextOpenid));

        String responseContent = this.wxMpService.post(url, json.toString());
        return WxTagListUser.fromJson(responseContent);
    }

    @Override
    public boolean batchTagging(Long tagId, String[] openids)
            throws WxErrorException {
        String url = API_URL_PREFIX + "/members/batchtagging";

        JsonObject json = new JsonObject();
        json.addProperty("tagid", tagId);
        JsonArray openidArrayJson = new JsonArray();
        for (String openid : openids) {
            openidArrayJson.add(openid);
        }
        json.add("openid_list", openidArrayJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public boolean batchUntagging(Long tagId, String[] openids)
            throws WxErrorException {
        String url = API_URL_PREFIX + "/members/batchuntagging";

        JsonObject json = new JsonObject();
        json.addProperty("tagid", tagId);
        JsonArray openidArrayJson = new JsonArray();
        for (String openid : openids) {
            openidArrayJson.add(openid);
        }
        json.add("openid_list", openidArrayJson);

        String responseContent = this.wxMpService.post(url, json.toString());
        WxError wxError = WxError.fromJson(responseContent);
        if (wxError.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(wxError);
    }

    @Override
    public List<Long> userTagList(String openid) throws WxErrorException {
        String url = API_URL_PREFIX + "/getidlist";

        JsonObject json = new JsonObject();
        json.addProperty("openid", openid);

        String responseContent = this.wxMpService.post(url, json.toString());

        return WxMpGsonBuilder.create().fromJson(
                new JsonParser().parse(responseContent).getAsJsonObject().get("tagid_list"),
                new TypeToken<List<Long>>() {
                }.getType());
    }
}
