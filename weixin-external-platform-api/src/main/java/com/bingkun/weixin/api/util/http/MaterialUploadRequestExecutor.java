package com.bingkun.weixin.api.util.http;

import com.bingkun.weixin.api.dto.material.WxMpMaterial;
import com.bingkun.weixin.api.dto.material.WxMpMaterialUploadResult;
import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.http.RequestExecutor;
import com.bingkun.weixin.common.util.http.Utf8ResponseHandler;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class MaterialUploadRequestExecutor implements RequestExecutor<WxMpMaterialUploadResult, WxMpMaterial> {

    @Override
    public WxMpMaterialUploadResult execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, WxMpMaterial material) throws WxErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (httpProxy != null) {
            RequestConfig response = RequestConfig.custom().setProxy(httpProxy).build();
            httpPost.setConfig(response);
        }

        if (material == null) {
            throw new WxErrorException(WxError.newBuilder().setErrorMsg("非法请求，material参数为空").build());
        }

        File file = material.getFile();
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }

        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder
                .addBinaryBody("media", file)
                .setMode(HttpMultipartMode.RFC6532);
        Map<String, String> form = material.getForm();
        if (material.getForm() != null) {
            multipartEntityBuilder.addTextBody("description", WxGsonBuilder.create().toJson(form));
        }

        httpPost.setEntity(multipartEntityBuilder.build());
        httpPost.setHeader("Content-Type", ContentType.MULTIPART_FORM_DATA.toString());

        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            WxError error = WxError.fromJson(responseContent);
            if (error.getErrorCode() != 0) {
                throw new WxErrorException(error);
            } else {
                return WxMpMaterialUploadResult.fromJson(responseContent);
            }
        } finally {
            httpPost.releaseConnection();
        }
    }

}
