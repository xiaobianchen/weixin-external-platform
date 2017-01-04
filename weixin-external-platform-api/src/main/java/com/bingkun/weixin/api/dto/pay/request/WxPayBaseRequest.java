package com.bingkun.weixin.api.dto.pay.request;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}
