package com.bingkun.weixin.api.impl;

import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.api.WxMpTemplateMsgService;
import com.bingkun.weixin.bean.template.WxMpTemplate;
import com.bingkun.weixin.bean.template.WxMpTemplateIndustry;
import com.bingkun.weixin.bean.template.WxMpTemplateMessage;
import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;


/**
 * Created by chenxiaobian on 2017/1/4.
 */
public class WxMpTemplateMsgServiceImpl implements WxMpTemplateMsgService {
    public static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/template";
    private static final JsonParser JSON_PARSER = new JsonParser();

    private WxMpService wxMpService;

    public WxMpTemplateMsgServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public String sendTemplateMsg(WxMpTemplateMessage templateMessage) throws WxErrorException {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send";
        String responseContent = this.wxMpService.post(url, templateMessage.toJson());
        final JsonObject jsonObject = JSON_PARSER.parse(responseContent).getAsJsonObject();
        if (jsonObject.get("errcode").getAsInt() == 0) {
            return jsonObject.get("msgid").getAsString();
        }
        throw new WxErrorException(WxError.fromJson(responseContent));
    }

    @Override
    public boolean setIndustry(WxMpTemplateIndustry wxMpIndustry) throws WxErrorException {
        if (null == wxMpIndustry.getPrimaryIndustry() || null == wxMpIndustry.getPrimaryIndustry().getId()
                || null == wxMpIndustry.getSecondIndustry() || null == wxMpIndustry.getSecondIndustry().getId()) {
            throw new IllegalArgumentException("行业Id不能为空，请核实");
        }

        String url = API_URL_PREFIX + "/api_set_industry";
        this.wxMpService.post(url, wxMpIndustry.toJson());
        return true;
    }

    @Override
    public WxMpTemplateIndustry getIndustry() throws WxErrorException {
        String url = API_URL_PREFIX + "/get_industry";
        String responseContent = this.wxMpService.get(url, null);
        return WxMpTemplateIndustry.fromJson(responseContent);
    }

    @Override
    public String addTemplate(String shortTemplateId) throws WxErrorException {
        String url = API_URL_PREFIX + "/api_add_template";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("template_id_short", shortTemplateId);
        String responseContent = this.wxMpService.post(url, jsonObject.toString());
        final JsonObject result = JSON_PARSER.parse(responseContent).getAsJsonObject();
        if (result.get("errcode").getAsInt() == 0) {
            return result.get("template_id").getAsString();
        }

        throw new WxErrorException(WxError.fromJson(responseContent));
    }

    @Override
    public List<WxMpTemplate> getAllPrivateTemplate() throws WxErrorException {
        String url = API_URL_PREFIX + "/get_all_private_template";
        return WxMpTemplate.fromJson(this.wxMpService.get(url, null));
    }

    @Override
    public boolean delPrivateTemplate(String templateId) throws WxErrorException {
        String url = API_URL_PREFIX + "/del_private_template";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("template_id", templateId);
        String responseContent = this.wxMpService.post(url, jsonObject.toString());
        WxError error = WxError.fromJson(responseContent);
        if (error.getErrorCode() == 0) {
            return true;
        }

        throw new WxErrorException(error);
    }

}
