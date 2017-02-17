package com.bingkun.weixin.util.http;


import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.http.InputStreamResponseHandler;
import com.bingkun.weixin.common.util.http.RequestExecutor;
import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenxiaobian 2017/2/10
 */
public class MaterialVoiceAndImageDownloadRequestExecutor implements RequestExecutor<InputStream, String> {

    public MaterialVoiceAndImageDownloadRequestExecutor() {
        super();
    }

    public MaterialVoiceAndImageDownloadRequestExecutor(File tmpDirFile) {
        super();
    }

    @Override
    public InputStream execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, String materialId) throws WxErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (httpProxy != null) {
            RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
            httpPost.setConfig(config);
        }

        Map<String, String> params = new HashMap<>();
        params.put("media_id", materialId);
        httpPost.setEntity(new StringEntity(WxGsonBuilder.create().toJson(params)));
        try (CloseableHttpResponse response = httpclient.execute(httpPost);
             InputStream inputStream = InputStreamResponseHandler.INSTANCE.handleResponse(response);) {
            // 下载媒体文件出错
            byte[] responseContent = IOUtils.toByteArray(inputStream);
            String responseContentString = new String(responseContent, "UTF-8");
            if (responseContentString.length() < 100) {
                try {
                    WxError wxError = WxGsonBuilder.create().fromJson(responseContentString, WxError.class);
                    if (wxError.getErrorCode() != 0) {
                        throw new WxErrorException(wxError);
                    }
                } catch (com.google.gson.JsonSyntaxException ex) {
                    return new ByteArrayInputStream(responseContent);
                }
            }
            return new ByteArrayInputStream(responseContent);
        } finally {
            httpPost.releaseConnection();
        }
    }

}
