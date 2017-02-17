package com.bingkun.weixin.api.impl;


import com.bingkun.weixin.api.WxMpDeviceService;
import com.bingkun.weixin.api.WxMpService;
import com.bingkun.weixin.bean.device.*;
import com.bingkun.weixin.common.exception.WxErrorException;

/**
 * Created by chenxiaobian on 2017/1/4.
 */
public class WxMpDeviceServiceImpl implements WxMpDeviceService {
  private static final String API_URL_PREFIX = "https://api.weixin.qq.com/device";

  private WxMpService wxMpService;

  WxMpDeviceServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public TransMsgResp transMsg(WxDeviceMsg msg) throws WxErrorException {
    String url = API_URL_PREFIX + "/transmsg";
    String response = this.wxMpService.post(url,msg.toJson());
    return TransMsgResp.fromJson(response);
  }

  @Override
  public WxDeviceQrCodeResult getQrCode(String productId) throws WxErrorException {
    String url = API_URL_PREFIX + "/getqrcode";
    String response = this.wxMpService.get(url, "product_id=" + productId);
    return WxDeviceQrCodeResult.fromJson(response);
  }

  @Override
  public WxDeviceAuthorizeResult authorize(WxDeviceAuthorize wxDeviceAuthorize) throws WxErrorException {
    String url = API_URL_PREFIX + "/authorize_device";
    String response = this.wxMpService.post(url,wxDeviceAuthorize.toJson());
    return WxDeviceAuthorizeResult.fromJson(response);
  }

  @Override
  public WxDeviceBindResult bind(WxDeviceBind wxDeviceBind) throws WxErrorException {
    String url = API_URL_PREFIX + "/bind";
    String response = this.wxMpService.post(url,wxDeviceBind.toJson());
    return WxDeviceBindResult.fromJson(response);
  }

  @Override
  public WxDeviceBindResult compelBind(WxDeviceBind wxDeviceBind) throws WxErrorException {
    String url = API_URL_PREFIX + "/compel_bind";
    String response = this.wxMpService.post(url,wxDeviceBind.toJson());
    return WxDeviceBindResult.fromJson(response);
  }

  @Override
  public WxDeviceBindResult unbind(WxDeviceBind wxDeviceBind) throws WxErrorException {
    String url = API_URL_PREFIX + "/unbind?";
    String response = this.wxMpService.post(url, wxDeviceBind.toJson());
    return WxDeviceBindResult.fromJson(response);
  }

  @Override
  public WxDeviceBindResult compelUnbind(WxDeviceBind wxDeviceBind) throws WxErrorException {
    String url = API_URL_PREFIX + "/compel_unbind?";
    String response = this.wxMpService.post(url, wxDeviceBind.toJson());
    return WxDeviceBindResult.fromJson(response);
  }
}

