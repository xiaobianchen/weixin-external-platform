package com.bingkun.weixin.common.util.http;

import com.bingkun.weixin.common.dto.result.WxError;
import com.bingkun.weixin.common.exception.WxErrorException;
import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * Created by chenxiaobian on 17/1/1.
 * 简单的POST请求执行器，请求的参数是String, 返回的结果也是String
 */
public class SimplePostRequestExecutor implements RequestExecutor<String, String> {

    @Override
    public String execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, String postEntity) throws WxErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (httpProxy != null) {
            RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
            httpPost.setConfig(config);
        }

        if (postEntity != null) {
            StringEntity entity = new StringEntity(postEntity, Consts.UTF_8);
            httpPost.setEntity(entity);
        }

        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            if (responseContent.isEmpty()) {
                throw new WxErrorException(
                        WxError.newBuilder().setErrorCode(9999).setErrorMsg("无响应内容")
                                .build());
            }

            if (responseContent.startsWith("<xml>")) {
                //xml格式输出直接返回
                return responseContent;
            }

            WxError error = WxError.fromJson(responseContent);
            if (error.getErrorCode() != 0) {
                throw new WxErrorException(error);
            }
            return responseContent;
        } finally {
            httpPost.releaseConnection();
        }
    }

}
