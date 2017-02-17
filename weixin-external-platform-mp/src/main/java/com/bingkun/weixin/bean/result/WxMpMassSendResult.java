package com.bingkun.weixin.bean.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 *
 * 群发消息一发送就返回的结果
 */
public class WxMpMassSendResult implements Serializable {
  private static final long serialVersionUID = -4816336807575562818L;
  private String errorCode;
  private String errorMsg;
  private String msgId;
  private String msgDataId;

  public String getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getMsgId() {
    return this.msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public String getMsgDataId() {
    return this.msgDataId;
  }

  public void setMsgDataId(String msgDataId) {
    this.msgDataId = msgDataId;
  }

  public static WxMpMassSendResult fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(json, WxMpMassSendResult.class);
  }

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

}
