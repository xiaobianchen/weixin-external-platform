package com.bingkun.weixin.mp.api;

import com.bingkun.weixin.common.dto.WxJsapiSignature;
import com.bingkun.weixin.common.dto.menu.WxMenu;
import com.bingkun.weixin.common.dto.result.WxMediaUploadResult;
import com.bingkun.weixin.common.exception.WxErrorException;
import com.bingkun.weixin.common.util.http.RequestExecutor;
import com.bingkun.weixin.mp.dto.*;
import com.bingkun.weixin.mp.dto.result.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public WxMediaUploadResult mediaUpload(String mediaType, String fileType, InputStream inputStream) throws WxErrorException, IOException {
        return null;
    }

    @Override
    public WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news) throws WxErrorException {
        return null;
    }

    @Override
    public InputStream materialImageOrVoiceDownload(String media_id) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMaterialVideoInfoResult materialVideoInfo(String media_id) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMaterialNews materialNewsInfo(String media_id) throws WxErrorException {
        return null;
    }

    @Override
    public boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate) throws WxErrorException {
        return false;
    }

    @Override
    public boolean materialDelete(String media_id) throws WxErrorException {
        return false;
    }

    @Override
    public WxMpMaterialCountResult materialCount() throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) throws WxErrorException {
        return null;
    }

    @Override
    public WxMediaUploadResult mediaUpload(String mediaType, File file) throws WxErrorException {
        return null;
    }

    @Override
    public File mediaDownload(String media_id) throws WxErrorException {
        return null;
    }

    @Override
    public void customMessageSend(WxMpCustomMessage message) throws WxErrorException {

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
    public WxMpMassSendResult massGroupMessageSend(WxMpMassGroupMessage message) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) throws WxErrorException {
        return null;
    }

    @Override
    public void menuCreate(WxMenu menu) throws WxErrorException {

    }

    @Override
    public void menuDelete() throws WxErrorException {

    }

    @Override
    public void menuDelete(String menuid) throws WxErrorException {

    }

    @Override
    public WxMenu menuGet() throws WxErrorException {
        return null;
    }

    @Override
    public WxMenu menuTryMatch(String userid) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpGroup groupCreate(String name) throws WxErrorException {
        return null;
    }

    @Override
    public List<WxMpGroup> groupGet() throws WxErrorException {
        return null;
    }

    @Override
    public long userGetGroup(String openid) throws WxErrorException {
        return 0;
    }

    @Override
    public void groupUpdate(WxMpGroup group) throws WxErrorException {

    }

    @Override
    public void userUpdateGroup(String openid, long to_groupid) throws WxErrorException {

    }

    @Override
    public void userUpdateRemark(String openid, String remark) throws WxErrorException {

    }

    @Override
    public WxMpUser userInfo(String openid, String lang) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpUserList userList(String next_openid) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpQrCodeTicket qrCodeCreateTmpTicket(int scene_id, Integer expire_seconds) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpQrCodeTicket qrCodeCreateLastTicket(int scene_id) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpQrCodeTicket qrCodeCreateLastTicket(String scene_str) throws WxErrorException {
        return null;
    }

    @Override
    public File qrCodePicture(WxMpQrCodeTicket ticket) throws WxErrorException {
        return null;
    }

    @Override
    public String shortUrl(String long_url) throws WxErrorException {
        return null;
    }

    @Override
    public String templateSend(WxMpTemplateMessage templateMessage) throws WxErrorException {
        return null;
    }

    @Override
    public WxMpSemanticQueryResult semanticQuery(WxMpSemanticQuery semanticQuery) throws WxErrorException {
        return null;
    }

    @Override
    public String oauth2buildAuthorizationUrl(String scope, String state) {
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
    public List<WxMpUserSummary> getUserSummary(Date beginDate, Date endDate) throws WxErrorException {
        return null;
    }

    @Override
    public List<WxMpUserCumulate> getUserCumulate(Date beginDate, Date endDate) throws WxErrorException {
        return null;
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
    public void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider) {

    }

    @Override
    public void setRetrySleepMillis(int retrySleepMillis) {

    }

    @Override
    public void setMaxRetryTimes(int maxRetryTimes) {

    }

    @Override
    public WxMpPrepayIdResult getPrepayId(String openId, String outTradeNo, double amt, String body, String tradeType, String ip, String notifyUrl) {
        return null;
    }

    @Override
    public WxMpPrepayIdResult getPrepayId(Map<String, String> parameters) {
        return null;
    }

    @Override
    public Map<String, String> getJSSDKPayInfo(Map<String, String> parameters) {
        return null;
    }

    @Override
    public Map<String, String> getJSSDKPayInfo(String openId, String outTradeNo, double amt, String body, String tradeType, String ip, String notifyUrl) {
        return null;
    }

    @Override
    public WxMpPayResult getJSSDKPayResult(String transactionId, String outTradeNo) {
        return null;
    }

    @Override
    public WxMpPayCallback getJSSDKCallbackData(String xmlData) {
        return null;
    }

    @Override
    public boolean checkJSSDKCallbackDataSignature(Map<String, String> kvm, String signature) {
        return false;
    }

    @Override
    public WxRedpackResult sendRedpack(Map<String, String> parameters) throws WxErrorException {
        return null;
    }
}
