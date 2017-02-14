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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenxiaobian on 17/1/20
 * 微信API的Service
 */
public interface WxMpService {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 验证推送过来的消息的正确性
     *
     * @param timestamp  时间戳
     * @param nonce      随机数
     * @param signature  微信加密签名
     * @return
     */
    public boolean checkSignature(String timestamp, String nonce, String signature);

    /**
     * 获取access_token, 不强制刷新access_token
     *
     */
    public String getAccessToken() throws WxErrorException;

    /**
     * 获取access_token，本方法线程安全
     * 且在多线程同时刷新时只刷新一次，避免超出2000次/日的调用次数上限
     *
     * @param forceRefresh 强制刷新
     * @return
     */
    public String getAccessToken(boolean forceRefresh) throws WxErrorException;

    /**
     * 获得jsapi_ticket,不强制刷新jsapi_ticket
     *
     * @return
     * @throws WxErrorException
     * @see #getJsapiTicket(boolean)
     */
    public String getJsapiTicket() throws WxErrorException;

    /**
     * 获得jsapi_ticket
     * 获得时会检查jsapiToken是否过期，如果过期了，那么就刷新一下，否则就什么都不干
     *
     * @param forceRefresh 强制刷新
     * @return
     * @throws WxErrorException
     */
    public String getJsapiTicket(boolean forceRefresh) throws WxErrorException;

    /**
     * 创建调用jsapi时所需要的签名
     *
     * @param url url
     * @return
     */
    public WxJsapiSignature createJsapiSignature(String url) throws WxErrorException;

    /**
     * 上传多媒体文件
     *
     * 上传的多媒体文件有格式和大小限制，如下：
     *   图片（image）: 1M，支持JPG格式
     *   语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
     *   视频（video）：10MB，支持MP4格式
     *   缩略图（thumb）：64KB，支持JPG格式
     *
     * @param inputStream 输入流
     * @throws WxErrorException
     */
    public WxMediaUploadResult mediaUpload(String mediaType, String fileType, InputStream inputStream) throws WxErrorException, IOException;

    /**
     * 上传非图文永久素材
     *
     * 上传的多媒体文件有格式和大小限制，如下：
     *   图片（image）: 图片大小不超过2M，支持bmp/png/jpeg/jpg/gif格式
     *   语音（voice）：语音大小不超过5M，长度不超过60秒，支持mp3/wma/wav/amr格式
     *   视频（video）：在上传视频素材时需要POST另一个表单，id为description，包含素材的描述信息，内容格式为JSON
     *   缩略图（thumb）：文档未说明
     *
     */
    public WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material) throws WxErrorException;

    /**
     * 上传永久图文素材
     *
     * @return
     * @throws WxErrorException
     */
    public WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news) throws WxErrorException;

    /**
     * 下载声音或者图片永久素材
     *
     * @param media_id 永久素材的id
     * @return
     * @throws WxErrorException
     */
    public InputStream materialImageOrVoiceDownload(String media_id) throws WxErrorException;

    /**
     * 获取视频永久素材的信息和下载地址
     *
     * @param media_id 永久素材的id
     * @return
     * @throws WxErrorException
     */
    public WxMpMaterialVideoInfoResult materialVideoInfo(String media_id) throws WxErrorException;

    /**
     * 获取图文永久素材的信息
     *
     * @param media_id 永久素材的id
     * @return
     * @throws WxErrorException
     */
    public WxMpMaterialNews materialNewsInfo(String media_id) throws WxErrorException;

    /**
     * 更新图文永久素材
     *
     * @return
     * @throws WxErrorException
     */
    public boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate) throws WxErrorException;

    /**
     * 删除永久素材
     *
     * @param media_id 永久素材的id
     * @return
     * @throws WxErrorException
     */
    public boolean materialDelete(String media_id) throws WxErrorException;

    /**
     * 获取各类素材总数
     *
     * @return
     * @throws WxErrorException
     */
    public WxMpMaterialCountResult materialCount() throws WxErrorException;

    /**
     * 分页获取图文素材列表
     *
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count  返回素材的数量，取值在1到20之间
     * @return
     * @throws WxErrorException
     */
    public WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WxErrorException;

    /**
     * 分页获取其他媒体素材列表
     *
     */
    public WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) throws WxErrorException;

    /**
     * @param mediaType
     * @param file
     * @throws WxErrorException
     * @see #mediaUpload(String, String, InputStream)
     */
    public WxMediaUploadResult mediaUpload(String mediaType, File file) throws WxErrorException;

    /**
     * 下载多媒体文件
     *
     * @return 保存到本地的临时文件
     * @throws WxErrorException
     * @params media_id
     */
    public File mediaDownload(String media_id) throws WxErrorException;

    /**
     * 发送客服消息
     *
     * @param message
     * @throws WxErrorException
     */
    public void customMessageSend(WxMpCustomMessage message) throws WxErrorException;

    /**
     * 上传群发用的图文消息，上传后才能群发图文消息
     *
     * @param news
     * @throws WxErrorException
     */
    public WxMpMassUploadResult massNewsUpload(WxMpMassNews news) throws WxErrorException;

    /**
     * 上传群发用的视频，上传后才能群发视频消息
     *
     * @return
     * @throws WxErrorException
     */
    public WxMpMassUploadResult massVideoUpload(WxMpMassVideo video) throws WxErrorException;

    /**
     * 分组群发消息
     *
     * @param message
     * @return
     * @throws WxErrorException
     */
    public WxMpMassSendResult massGroupMessageSend(WxMpMassGroupMessage message) throws WxErrorException;

    /**
     * 按openId列表群发消息
     *
     * @param message
     * @return
     * @throws WxErrorException
     */
    public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) throws WxErrorException;

    /**
     * 自定义菜单创建接口
     *
     * @param menu
     * @throws WxErrorException
     */
    public void menuCreate(WxMenu menu) throws WxErrorException;

    /**
     * 自定义菜单删除接口
     *
     * @throws WxErrorException
     */
    public void menuDelete() throws WxErrorException;

    /**
     * 删除个性化菜单接口
     *
     * @param menuid
     * @throws WxErrorException
     */
    public void menuDelete(String menuid) throws WxErrorException;

    /**
     * 自定义菜单查询接口
     *
     * @return
     * @throws WxErrorException
     */
    public WxMenu menuGet(String accessToken) throws WxErrorException;

    /**
     * 测试个性化菜单匹配结果
     *
     * @param userid 可以是粉丝的OpenID，也可以是粉丝的微信号。
     * @throws WxErrorException
     */
    public WxMenu menuTryMatch(String userid) throws WxErrorException;

    /**
     * 分组管理接口 - 创建分组
     * 最多支持创建500个分组
     *
     * @param name 分组名字（30个字符以内）
     * @throws WxErrorException
     */
    public WxMpGroup groupCreate(String name) throws WxErrorException;

    /**
     * 分组管理接口 - 查询所有分组
     *
     * @return
     * @throws WxErrorException
     */
    public List<WxMpGroup> groupGet() throws WxErrorException;

    /**
     * 分组管理接口 - 查询用户所在分组
     *
     * @param openid 微信用户的openid
     * @throws WxErrorException
     */
    public long userGetGroup(String openid) throws WxErrorException;

    /**
     * 分组管理接口 - 修改分组名
     *
     * 如果id为0(未分组),1(黑名单),2(星标组)，或者不存在的id，微信会返回系统繁忙的错误
     *
     * @param group 要更新的group，group的id,name必须设置
     * @throws WxErrorException
     */
    public void groupUpdate(WxMpGroup group) throws WxErrorException;

    /**
     * 分组管理接口 - 移动用户分组
     *
     * 如果to_groupid为0(未分组),1(黑名单),2(星标组)，或者不存在的id，微信会返回系统繁忙的错误
     *
     * @param openid     用户openid
     * @param to_groupid 移动到的分组id
     * @throws WxErrorException
     */
    public void userUpdateGroup(String openid, long to_groupid) throws WxErrorException;

    /**
     * 设置用户备注名接口
     *
     * @param openid 用户openid
     * @param remark 备注名
     * @throws WxErrorException
     */
    public void userUpdateRemark(String openid, String remark) throws WxErrorException;

    /**
     * 获取用户基本信息
     *
     * @param openid 用户openid
     * @param lang   语言，zh_CN 简体(默认)，zh_TW 繁体，en 英语
     * @return
     * @throws WxErrorException
     */
    public WxMpUser userInfo(String openid, String lang) throws WxErrorException;

    /**
     * 获取关注者列表
     *
     * @param next_openid 可选，第一个拉取的OPENID，null为从头开始拉取
     * @return
     * @throws WxErrorException
     */
    public WxMpUserList userList(String next_openid) throws WxErrorException;

    /**
     * 换取临时二维码ticket
     *
     * @param scene_id       参数。
     * @param expire_seconds 过期秒数，默认60秒，最小60秒，最大1800秒
     * @return
     * @throws WxErrorException
     */
    public WxMpQrCodeTicket qrCodeCreateTmpTicket(int scene_id, Integer expire_seconds) throws WxErrorException;

    /**
     * 换取永久二维码ticket
     *
     * @param scene_id 参数。永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     * @throws WxErrorException
     */
    public WxMpQrCodeTicket qrCodeCreateLastTicket(int scene_id) throws WxErrorException;

    /**
     * 换取永久字符串二维码ticket
     *
     * @param scene_str 参数。字符串类型长度现在为1到64
     * @return
     * @throws WxErrorException
     */
    public WxMpQrCodeTicket qrCodeCreateLastTicket(String scene_str) throws WxErrorException;

    /**
     * 换取二维码图片文件，jpg格式
     *
     * @param ticket 二维码ticket
     * @return
     * @throws WxErrorException
     */
    public File qrCodePicture(WxMpQrCodeTicket ticket) throws WxErrorException;

    /**
     * 长链接转短链接接口
     *
     * @param long_url
     * @return
     * @throws WxErrorException
     */
    public String shortUrl(String long_url) throws WxErrorException;

    /**
     * 发送模板消息
     *
     * @param templateMessage
     * @return msgid
     * @throws WxErrorException
     */
    public String templateSend(WxMpTemplateMessage templateMessage) throws WxErrorException;

    /**
     * 语义查询接口
     *
     * @param semanticQuery
     * @return
     * @throws WxErrorException
     */
    WxMpSemanticQueryResult semanticQuery(WxMpSemanticQuery semanticQuery) throws WxErrorException;

    /**
     * 构造oauth2授权的url连接
     *
     * @param scope
     * @param state
     * @return url
     */
    public String oauth2buildAuthorizationUrl(String scope, String state);

    /**
     * 构造oauth2授权的url连接
     *
     * @param redirectURI 用户授权完成后的重定向链接，无需urlencode, 方法内会进行encode
     * @param scope
     * @param state
     * @return url
     */
    public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state);

    /**
     * 用code换取oauth2的access token
     *
     * @param code
     * @return
     */
    public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WxErrorException;

    /**
     * 刷新oauth2的access token
     *
     * @param refreshToken
     * @return
     */
    public WxMpOAuth2AccessToken oauth2refreshAccessToken(String refreshToken) throws WxErrorException;

    /**
     * 用oauth2获取用户信息, 当前面引导授权时的scope是snsapi_userinfo的时候才可以
     *
     * @param oAuth2AccessToken
     * @param lang              zh_CN, zh_TW, en
     */
    public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang) throws WxErrorException;

    /**
     * 验证oauth2的access token是否有效
     *
     * @param oAuth2AccessToken
     * @return
     */
    public boolean oauth2validateAccessToken(WxMpOAuth2AccessToken oAuth2AccessToken);

    /**
     * 获取微信服务器IP地址
     *
     * @return
     * @throws WxErrorException
     */
    String[] getCallbackIP() throws WxErrorException;

    /**
     * 获取用户增减数据
     *
     * @param beginDate 最大时间跨度7天
     * @param endDate   endDate不能早于begingDate
     * @return
     * @throws WxErrorException
     */
    List<WxMpUserSummary> getUserSummary(Date beginDate, Date endDate) throws WxErrorException;

    /**
     * 获取累计用户数据
     *
     * @param beginDate 最大时间跨度7天
     * @param endDate   endDate不能早于begingDate
     * @return
     * @throws WxErrorException
     */
    List<WxMpUserCumulate> getUserCumulate(Date beginDate, Date endDate) throws WxErrorException;

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的GET请求
     *
     * @param url
     * @param queryParam
     * @return
     * @throws WxErrorException
     */
    String get(String url, String queryParam) throws WxErrorException;

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的POST请求
     *
     * @param url
     * @param postData
     * @return
     * @throws WxErrorException
     */
    String post(String url, String postData) throws WxErrorException;

    /**
     * Service没有实现某个API的时候，可以用这个，
     *
     * @param executor
     * @param uri
     * @param data
     * @param <T>
     * @param <E>
     * @return
     * @throws WxErrorException
     */
    public <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws WxErrorException;

    public void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider);

    /**
     * 设置当微信系统响应系统繁忙时，要等待多少 retrySleepMillis(ms) * 2^(重试次数 - 1) 再发起重试
     * 默认：1000ms
     *
     * @param retrySleepMillis
     */
    void setRetrySleepMillis(int retrySleepMillis);

    /**
     * 设置当微信系统响应系统繁忙时，最大重试次数
     * 默认：5次
     *
     * @param maxRetryTimes
     */
    void setMaxRetryTimes(int maxRetryTimes);

    /**
     * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
     *
     * @param openId     支付人openId
     * @param outTradeNo 商户端对应订单号
     * @param amt        金额(单位元)
     * @param body       商品描述
     * @param tradeType  交易类型 JSAPI，NATIVE，APP，WAP
     * @param ip         发起支付的客户端IP
     * @param notifyUrl  通知地址
     * @return
     */
    @Deprecated
    WxMpPrepayIdResult getPrepayId(String openId, String outTradeNo, double amt, String body, String tradeType, String ip, String notifyUrl);

    /**
     * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
     *
     * @param parameters All required/optional parameters for weixin payment
     * @return
     * @throws IllegalArgumentException
     */
    WxMpPrepayIdResult getPrepayId(Map<String, String> parameters);

    /**
     * 该接口调用“统一下单”接口，并拼装JSSDK发起支付请求需要的参数
     *
     * @param parameters the required or optional parameters
     * @return
     */
    Map<String, String> getJSSDKPayInfo(Map<String, String> parameters);

    /**
     * 该接口调用“统一下单”接口，并拼装JSSDK发起支付请求需要的参数
     *
     * @param openId     支付人openId
     * @param outTradeNo 商户端对应订单号
     * @param amt        金额(单位元)
     * @param body       商品描述
     * @param tradeType  交易类型 JSAPI，NATIVE，APP，WAP
     * @param ip         发起支付的客户端IP
     * @param notifyUrl  通知地址
     * @return
     * @deprecated Use me.chanjar.weixin.mp.api.WxMpService.getJSSDKPayInfo(Map<String, String>) instead
     */
    @Deprecated
    Map<String, String> getJSSDKPayInfo(String openId, String outTradeNo, double amt, String body, String tradeType, String ip, String notifyUrl);

    /**
     * 该接口提供所有微信支付订单的查询,当支付通知处理异常戒丢失的情冴,商户可以通过该接口查询订单支付状态。
     *
     * @param transactionId
     * @param outTradeNo
     */
    WxMpPayResult getJSSDKPayResult(String transactionId, String outTradeNo);

    /**
     * 读取支付结果通知
     *
     * @param xmlData
     * @return
     */
    WxMpPayCallback getJSSDKCallbackData(String xmlData);

    /**
     * 计算Map键值对是否和签名相符,
     * 按照字段名的 ASCII 码从小到大排序(字典序)后,使用 URL 键值对的 格式(即 key1=value1&key2=value2...)拼接成字符串
     *
     * @param kvm
     * @param signature
     * @return
     */
    public boolean checkJSSDKCallbackDataSignature(Map<String, String> kvm, String signature);

    /**
     * 发送微信红包给个人用户
     *
     * @param parameters
     * @return
     * @throws WxErrorException
     */
    public WxRedpackResult sendRedpack(Map<String, String> parameters) throws WxErrorException;
}
