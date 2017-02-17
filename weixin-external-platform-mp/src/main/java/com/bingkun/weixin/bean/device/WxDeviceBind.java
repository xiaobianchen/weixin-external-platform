package com.bingkun.weixin.bean.device;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chenxiaobian on 2016/12/10.
 */
public class WxDeviceBind extends AbstractDeviceBean{
  private String ticket;
  @SerializedName("device_id")
  private String deviceId;
  @SerializedName("openid")
  private String openId;

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }
}
