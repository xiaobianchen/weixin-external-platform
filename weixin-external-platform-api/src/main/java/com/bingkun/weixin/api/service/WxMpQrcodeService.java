package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.result.WxMpQrCodeTicket;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.io.File;

/**
 *
 * Created by chenxiaobian on 2017/1/2.
 *
 * 二维码相关操作接口
 *
 */
public interface WxMpQrcodeService {

  /**
   * 换取临时二维码ticket
   *
   * @param scene_id       参数。
   * @param expire_seconds 过期秒数，默认60秒，最小60秒，最大1800秒
   */
  WxMpQrCodeTicket qrCodeCreateTmpTicket(int scene_id, Integer expire_seconds) throws WxErrorException;

  /**
   * 换取永久二维码ticket
   *
   * @param scene_id 参数。永久二维码时最大值为100000（目前参数只支持1--100000）
   */
  WxMpQrCodeTicket qrCodeCreateLastTicket(int scene_id) throws WxErrorException;

  /**
   * 换取永久字符串二维码ticket
   *
   * @param scene_str 参数。字符串类型长度现在为1到64
   */
  WxMpQrCodeTicket qrCodeCreateLastTicket(String scene_str) throws WxErrorException;

  /**
   * 换取二维码图片文件，jpg格式
   *
   * @param ticket 二维码ticket
   */
  File qrCodePicture(WxMpQrCodeTicket ticket) throws WxErrorException;

  /**
   * 换取二维码图片url地址（可以选择是否生成压缩的网址）
   *
   * @param ticket       二维码ticket
   * @param needShortUrl 是否需要压缩的二维码地址
   */
  String qrCodePictureUrl(String ticket, boolean needShortUrl) throws WxErrorException;

  /**
   * 换取二维码图片url地址
   *
   * @param ticket 二维码ticket
   */
  String qrCodePictureUrl(String ticket) throws WxErrorException;

}
