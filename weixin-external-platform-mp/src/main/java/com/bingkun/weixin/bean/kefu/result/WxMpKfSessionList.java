package com.bingkun.weixin.bean.kefu.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WxMpKfSessionList {
  /**
   * 会话列表
   */
  @SerializedName("sessionlist")
  private List<WxMpKfSession> kfSessionList;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  public static WxMpKfSessionList fromJson(String json) {
    return WxMpGsonBuilder.INSTANCE.create().fromJson(json,
        WxMpKfSessionList.class);
  }

  public List<WxMpKfSession> getKfSessionList() {
    return this.kfSessionList;
  }

  public void setKfSessionList(List<WxMpKfSession> kfSessionList) {
    this.kfSessionList = kfSessionList;
  }
}
