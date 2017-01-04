package com.bingkun.weixin.api.dto.pay.request;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public abstract class WxPayBaseRequest {

  @XStreamAlias("appid")
  protected String appid;

  @XStreamAlias("mch_id")
  protected String mchId;

  @XStreamAlias("nonce_str")
  protected String nonceStr;

  @XStreamAlias("sign")
  protected String sign;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }
}
