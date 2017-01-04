package com.bingkun.weixin.mp.impl;

import com.bingkun.weixin.api.dto.*;
import com.bingkun.weixin.api.dto.result.*;
import com.bingkun.weixin.api.service.*;
import com.bingkun.weixin.common.dto.WxJsapiSignature;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.http.RequestExecutor;
import org.apache.http.HttpHost;

public class WxMpServiceImpl implements WxMpService {


    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        return false;
    }

    @Override
    public String getAccessToken() throws WxErrorException {
        return null;
    }

    @Override
    public String getAccessToken(boolean forceRefresh) throws WxErrorException {
        return null;
    }

    @Override
    public String getJsapiTicket() throws WxErrorException {
        return null;
    }

    @Override
    public String getJsapiTicket(boolean forceRefresh) throws WxErrorException {
        return null;
    }

    @Override
    public WxJsapiSignature createJsapiSignature(String url) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMassUploadResult massNewsUpload(WxMpMassNews news) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMassUploadResult massVideoUpload(WxMpMassVideo video) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMassSendResult massGroupMessageSend(WxMpMassTagMessage message) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMassSendResult massMessagePreview(WxMpMassPreviewMessage wxMpMassPreviewMessage) throws Exception {
        return null;
    }

    @Override
    public String shortUrl(String long_url) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpSemanticQueryResult semanticQuery(WxMpSemanticQuery semanticQuery) throws WxErrorException {
        return null;
    }

    @Override
    public String buildQrConnectUrl(String redirectURI, String scope, String state) {
        return null;
    }

    @Override
    public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state) {
        return null;
    }

    @Override
    public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpOAuth2AccessToken oauth2refreshAccessToken(String refreshToken) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang) throws WxErrorException {
        return null;
    }

    @Override
    public boolean oauth2validateAccessToken(WxMpOAuth2AccessToken oAuth2AccessToken) {
        return false;
    }

    @Override
    public String[] getCallbackIP() throws WxErrorException {
        return new String[0];
    }

    @Override
    public String get(String url, String queryParam) throws WxErrorException {
        return null;
    }

    @Override
    public String post(String url, String postData) throws WxErrorException {
        return null;
    }

    @Override
    public <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws WxErrorException {
        return null;
    }

    @Override
    public HttpHost getHttpProxy() {
        return null;
    }

    @Override
    public void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider) {

    }

    @Override
    public void setRetrySleepMillis(int retrySleepMillis) {

    }

    @Override
    public void setMaxRetryTimes(int maxRetryTimes) {

    }

    @Override
    public WxMpConfigStorage getWxMpConfigStorage() {
        return null;
    }

    @Override
    public WxMpKefuService getKefuService() {
        return null;
    }

    @Override
    public WxMpMaterialService getMaterialService() {
        return null;
    }

    @Override
    public WxMpMenuService getMenuService() {
        return null;
    }

    @Override
    public WxMpUserService getUserService() {
        return null;
    }

    @Override
    public WxMpUserTagService getUserTagService() {
        return null;
    }

    @Override
    public WxMpQrcodeService getQrcodeService() {
        return null;
    }

    @Override
    public WxMpCardService getCardService() {
        return null;
    }

    @Override
    public WxMpPayService getPayService() {
        return null;
    }

    @Override
    public WxMpDataCubeService getDataCubeService() {
        return null;
    }

    @Override
    public WxMpUserBlacklistService getBlackListService() {
        return null;
    }

    @Override
    public WxMpStoreService getStoreService() {
        return null;
    }

    @Override
    public WxMpTemplateMsgService getTemplateMsgService() {
        return null;
    }
}
