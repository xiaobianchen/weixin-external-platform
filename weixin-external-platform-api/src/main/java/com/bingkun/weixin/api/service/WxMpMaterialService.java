package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.material.*;
import com.bingkun.weixin.common.dto.result.WxMediaUploadResult;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.io.File;
import java.io.InputStream;

/**
 * Created by chenxiaobian on 2017/1/2.
 * 素材管理的相关接口，包括媒体管理的接口，
 */
public interface WxMpMaterialService {

  /**
   * 新增临时素材
   * 公众号经常有需要用到一些临时性的多媒体素材的场景，例如在使用接口特别是发送消息时，对多媒体文件、多媒体消息的获取和调用等操作，是通过media_id来进行的。
   * 素材管理接口对所有认证的订阅号和服务号开放。通过本接口，公众号可以新增临时素材（即上传临时多媒体文件）。
   */
  WxMediaUploadResult mediaUpload(String mediaType, File file) throws WxErrorException;

  /**
   * 新增临时素材
   * 本接口即为原“上传多媒体文件”接口。
   */
  WxMediaUploadResult mediaUpload(String mediaType, String fileType, InputStream inputStream) throws WxErrorException;

  /**
   * 获取临时素材
   * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件）。请注意，视频文件不支持https下载，调用该接口需http协议。
   *
   * @param media_id
   * @return 保存到本地的临时文件
   * @throws WxErrorException
   */
  File mediaDownload(String media_id) throws WxErrorException;

  /**
   * 上传图文消息内的图片获取URL
   * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
   *
   * @param file 上传的文件对象
   * @return WxMediaImgUploadResult 返回图片url
   * @throws WxErrorException
   */
  WxMediaImgUploadResult mediaImgUpload(File file) throws WxErrorException;

  /**
   * 新增非图文永久素材
   * 通过POST表单来调用接口，表单id为media，包含需要上传的素材内容，有filename、filelength、content-type等信息。请注意：图片素材将进入公众平台官网素材管理模块中的默认分组。
   * 新增永久视频素材需特别注意：
   *
   */
  WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material) throws WxErrorException;

  /**
   * 新增永久图文素材
   *
   * @param news 上传的图文消息, 请看{@link WxMpMaterialNews}
   */
  WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news) throws WxErrorException;

  /**
   * 获取声音或者图片永久素材
   */
  InputStream materialImageOrVoiceDownload(String mediaId) throws WxErrorException;

  /**
   * 获取视频永久素材的信息和下载地址
   *
   * @param mediaId 永久素材的id
   */
  WxMpMaterialVideoInfoResult materialVideoInfo(String mediaId) throws WxErrorException;

  /**
   * 获取图文永久素材的信息
   */
  WxMpMaterialNews materialNewsInfo(String mediaId) throws WxErrorException;

  /**
   * 修改永久图文素材
   */
  boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate) throws WxErrorException;

  /**
   * 删除永久素材
   * 在新增了永久素材后，开发者可以根据本接口来删除不再需要的永久素材，节省空间
   *
   * @param mediaId 永久素材的id
   */
  boolean materialDelete(String mediaId) throws WxErrorException;

  /**
   * 获取各类素材总数
   */
  WxMpMaterialCountResult materialCount() throws WxErrorException;

  /**
   * 分页获取图文素材列表
   *
   * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
   * @param count  返回素材的数量，取值在1到20之间
   */
  WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WxErrorException;

  /**
   * 分页获取其他媒体素材列表
   */
  WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) throws WxErrorException;

}
