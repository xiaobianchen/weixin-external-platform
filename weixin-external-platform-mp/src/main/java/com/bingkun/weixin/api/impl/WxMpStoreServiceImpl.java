package com.bingkun.weixin.api.impl;

import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.api.WxMpStoreService;
import com.bingkun.weixin.bean.store.WxMpStoreBaseInfo;
import com.bingkun.weixin.bean.store.WxMpStoreInfo;
import com.bingkun.weixin.bean.store.WxMpStoreListResult;
import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.BeanUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/4.
 */
public class WxMpStoreServiceImpl implements WxMpStoreService {
    private static final String API_BASE_URL = "http://api.weixin.qq.com/cgi-bin/poi";

    private WxMpService wxMpService;

    public WxMpStoreServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public void add(WxMpStoreBaseInfo request) throws WxErrorException {
        BeanUtils.checkRequiredFields(request);

        String url = API_BASE_URL + "/addpoi";
        String response = this.wxMpService.post(url, request.toJson());
        WxError wxError = WxError.fromJson(response);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public WxMpStoreBaseInfo get(String poiId) throws WxErrorException {
        String url = API_BASE_URL + "/getpoi";
        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("poi_id", poiId);
        String response = this.wxMpService.post(url, paramObject.toString());
        WxError wxError = WxError.fromJson(response);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
        return WxMpStoreBaseInfo.fromJson(new JsonParser().parse(response).getAsJsonObject()
                .get("business").getAsJsonObject().get("base_info").toString());
    }

    @Override
    public void delete(String poiId) throws WxErrorException {
        String url = API_BASE_URL + "/delpoi";
        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("poi_id", poiId);
        String response = this.wxMpService.post(url, paramObject.toString());
        WxError wxError = WxError.fromJson(response);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public WxMpStoreListResult list(int begin, int limit)
            throws WxErrorException {
        String url = API_BASE_URL + "/getpoilist";
        JsonObject params = new JsonObject();
        params.addProperty("begin", begin);
        params.addProperty("limit", limit);
        String response = this.wxMpService.post(url, params.toString());

        WxError wxError = WxError.fromJson(response);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }

        return WxMpStoreListResult.fromJson(response);
    }

    @Override
    public List<WxMpStoreInfo> listAll() throws WxErrorException {
        int limit = 50;
        WxMpStoreListResult list = this.list(0, limit);
        List<WxMpStoreInfo> stores = list.getBusinessList();
        if (list.getTotalCount() > limit) {
            int begin = limit;
            WxMpStoreListResult followingList = this.list(begin, limit);
            while (followingList.getBusinessList().size() > 0) {
                stores.addAll(followingList.getBusinessList());
                begin += limit;
                if (begin >= list.getTotalCount()) {
                    break;
                }
                followingList = this.list(begin, limit);
            }
        }

        return stores;
    }

    @Override
    public void update(WxMpStoreBaseInfo request) throws WxErrorException {
        String url = API_BASE_URL + "/updatepoi";
        String response = this.wxMpService.post(url, request.toJson());
        WxError wxError = WxError.fromJson(response);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public List<String> listCategories() throws WxErrorException {
        String url = API_BASE_URL + "/getwxcategory";
        String response = this.wxMpService.get(url, null);
        WxError wxError = WxError.fromJson(response);
        if (wxError.getErrorCode() != 0) {
            throw new WxErrorException(wxError);
        }

        return WxMpGsonBuilder.create().fromJson(
                new JsonParser().parse(response).getAsJsonObject().get("category_list"),
                new TypeToken<List<String>>() {
                }.getType());
    }

}
