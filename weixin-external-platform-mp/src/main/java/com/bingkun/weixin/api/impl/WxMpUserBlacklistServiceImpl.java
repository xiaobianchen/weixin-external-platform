package com.bingkun.weixin.api.impl;

import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.api.WxMpUserBlacklistService;
import com.bingkun.weixin.bean.result.WxMpUserBlacklistGetResult;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.http.SimplePostRequestExecutor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by chenxiaobian on 2017/1/4.
 */
public class WxMpUserBlacklistServiceImpl implements WxMpUserBlacklistService {
    private static final String API_BLACKLIST_PREFIX = "https://api.weixin.qq.com/cgi-bin/tags/members";
    private WxMpService wxMpService;

    public WxMpUserBlacklistServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMpUserBlacklistGetResult getBlacklist(String nextOpenid) throws WxErrorException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("begin_openid", nextOpenid);
        String url = API_BLACKLIST_PREFIX + "/getblacklist";
        String responseContent = this.wxMpService.execute(new SimplePostRequestExecutor(), url, jsonObject.toString());
        return WxMpUserBlacklistGetResult.fromJson(responseContent);
    }

    @Override
    public void pushToBlacklist(List<String> openidList) throws WxErrorException {
        Map<String, Object> map = new HashMap<>();
        map.put("openid_list", openidList);
        String url = API_BLACKLIST_PREFIX + "/batchblacklist";
        this.wxMpService.execute(new SimplePostRequestExecutor(), url, new Gson().toJson(map));
    }

    @Override
    public void pullFromBlacklist(List<String> openidList) throws WxErrorException {
        Map<String, Object> map = new HashMap<>();
        map.put("openid_list", openidList);
        String url = API_BLACKLIST_PREFIX + "/batchunblacklist";
        this.wxMpService.execute(new SimplePostRequestExecutor(), url, new Gson().toJson(map));
    }
}
