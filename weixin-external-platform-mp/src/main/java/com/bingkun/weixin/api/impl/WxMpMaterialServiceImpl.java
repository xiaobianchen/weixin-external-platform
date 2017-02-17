package com.bingkun.weixin.api.impl;

import com.bingkun.weixin.api.WxMpMaterialService;
import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.bean.material.*;
import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.dto.result.WxMediaUploadResult;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.fs.FileUtils;
import com.bingkun.weixin.common.util.http.MediaDownloadRequestExecutor;
import com.bingkun.weixin.common.util.http.MediaUploadRequestExecutor;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import com.bingkun.weixin.util.http.*;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chenxiaobian on 2017/1/4.
 */
public class WxMpMaterialServiceImpl implements WxMpMaterialService {
    private static final String MEDIA_API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/media";
    private static final String MATERIAL_API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/material";
    private WxMpService wxMpService;

    public WxMpMaterialServiceImpl(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @Override
    public WxMediaUploadResult mediaUpload(String mediaType, String fileType, InputStream inputStream) throws WxErrorException {
        try {
            return this.mediaUpload(mediaType, FileUtils.createTmpFile(inputStream, UUID.randomUUID().toString(), fileType));
        } catch (IOException e) {
            e.printStackTrace();
            throw new WxErrorException(WxError.newBuilder().setErrorMsg(e.getMessage()).build());
        }
    }

    @Override
    public WxMediaUploadResult mediaUpload(String mediaType, File file) throws WxErrorException {
        String url = MEDIA_API_URL_PREFIX + "/upload?type=" + mediaType;
        return this.wxMpService.execute(new MediaUploadRequestExecutor(), url, file);
    }

    @Override
    public File mediaDownload(String media_id) throws WxErrorException {
        String url = MEDIA_API_URL_PREFIX + "/get";
        return this.wxMpService.execute(
                new MediaDownloadRequestExecutor(this.wxMpService.getWxMpConfigStorage().getTmpDirFile()),
                url,
                "media_id=" + media_id);
    }

    @Override
    public WxMediaImgUploadResult mediaImgUpload(File file) throws WxErrorException {
        String url = MEDIA_API_URL_PREFIX + "/uploadimg";
        return this.wxMpService.execute(new MediaImgUploadRequestExecutor(), url, file);
    }

    @Override
    public WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/add_material?type=" + mediaType;
        return this.wxMpService.execute(new MaterialUploadRequestExecutor(), url, material);
    }

    @Override
    public WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news) throws WxErrorException {
        if (news == null || news.isEmpty()) {
            throw new IllegalArgumentException("news is empty!");
        }
        String url = MATERIAL_API_URL_PREFIX + "/add_news";
        String responseContent = this.wxMpService.post(url, news.toJson());
        return WxMpMaterialUploadResult.fromJson(responseContent);
    }

    @Override
    public InputStream materialImageOrVoiceDownload(String media_id) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/get_material";
        return this.wxMpService.execute(new MaterialVoiceAndImageDownloadRequestExecutor(this.wxMpService.getWxMpConfigStorage().getTmpDirFile()), url, media_id);
    }

    @Override
    public WxMpMaterialVideoInfoResult materialVideoInfo(String media_id) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/get_material";
        return this.wxMpService.execute(new MaterialVideoInfoRequestExecutor(), url, media_id);
    }

    @Override
    public WxMpMaterialNews materialNewsInfo(String media_id) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/get_material";
        return this.wxMpService.execute(new MaterialNewsInfoRequestExecutor(), url, media_id);
    }

    @Override
    public boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/update_news";
        String responseText = this.wxMpService.post(url, wxMpMaterialArticleUpdate.toJson());
        WxError wxError = WxError.fromJson(responseText);
        if (wxError.getErrorCode() == 0) {
            return true;
        } else {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public boolean materialDelete(String media_id) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/del_material";
        return this.wxMpService.execute(new MaterialDeleteRequestExecutor(), url, media_id);
    }

    @Override
    public WxMpMaterialCountResult materialCount() throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/get_materialcount";
        String responseText = this.wxMpService.get(url, null);
        WxError wxError = WxError.fromJson(responseText);
        if (wxError.getErrorCode() == 0) {
            return WxMpGsonBuilder.create().fromJson(responseText, WxMpMaterialCountResult.class);
        } else {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/batchget_material";
        Map<String, Object> params = new HashMap<>();
        params.put("type", WxConsts.MATERIAL_NEWS);
        params.put("offset", offset);
        params.put("count", count);
        String responseText = this.wxMpService.post(url, WxGsonBuilder.create().toJson(params));
        WxError wxError = WxError.fromJson(responseText);
        if (wxError.getErrorCode() == 0) {
            return WxMpGsonBuilder.create().fromJson(responseText, WxMpMaterialNewsBatchGetResult.class);
        } else {
            throw new WxErrorException(wxError);
        }
    }

    @Override
    public WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) throws WxErrorException {
        String url = MATERIAL_API_URL_PREFIX + "/batchget_material";
        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        params.put("offset", offset);
        params.put("count", count);
        String responseText = this.wxMpService.post(url, WxGsonBuilder.create().toJson(params));
        WxError wxError = WxError.fromJson(responseText);
        if (wxError.getErrorCode() == 0) {
            return WxMpGsonBuilder.create().fromJson(responseText, WxMpMaterialFileBatchGetResult.class);
        } else {
            throw new WxErrorException(wxError);
        }
    }

}
