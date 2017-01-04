package com.bingkun.weixin.common.util.http;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by chenxiaobian on 16/12/19.
 */
public interface ApacheHttpClientBuilder {

    /**
     * 构建httpclient实例
     */
    CloseableHttpClient build();

    /**
     * 代理服务器地址
     */
    ApacheHttpClientBuilder httpProxyHost(String httpProxyHost);

    /**
     * 代理服务器端口
     */
    ApacheHttpClientBuilder httpProxyPort(int httpProxyPort);

    /**
     * 代理服务器用户名
     */
    ApacheHttpClientBuilder httpProxyUsername(String httpProxyUsername);

    /**
     * 代理服务器密码
     */
    ApacheHttpClientBuilder httpProxyPassword(String httpProxyPassword);

    /**
     * ssl连接socket工厂
     */
    ApacheHttpClientBuilder sslConnectionSocketFactory(SSLConnectionSocketFactory sslConnectionSocketFactory);
}
