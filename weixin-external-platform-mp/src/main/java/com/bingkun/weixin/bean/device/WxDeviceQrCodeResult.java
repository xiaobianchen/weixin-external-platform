package com.bingkun.weixin.bean.device;

import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016/12/10.
 */
public class WxDeviceQrCodeResult extends AbstractDeviceBean{
  @SerializedName("deviceid")
  private String deviceId;
  @SerializedName("qrticket")
  private String qrTicket;
  @SerializedName("devicelicence")
  private String deviceLicence;
  @SerializedName("resp_msg")
  private RespMsg respMsg;

  public static WxDeviceQrCodeResult fromJson(String json) {
    return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxDeviceQrCodeResult.class);
  }

  public String getDeviceLicence() {
    return deviceLicence;
  }

  public void setDeviceLicence(String deviceLicence) {
    this.deviceLicence = deviceLicence;
  }

  public RespMsg getRespMsg() {
    return respMsg;
  }

  public void setRespMsg(RespMsg respMsg) {
    this.respMsg = respMsg;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getQrTicket() {
    return qrTicket;
  }

  public void setQrTicket(String qrTicket) {
    this.qrTicket = qrTicket;
  }
}
