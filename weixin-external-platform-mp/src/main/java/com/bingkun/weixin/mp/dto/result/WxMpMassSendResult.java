package com.bingkun.weixin.mp.dto.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * 群发消息一发送就返回的结果
 * 真正的群发消息是否发送成功要看
 */
public class WxMpMassSendResult implements Serializable {

    private String errorCode;
    private String errorMsg;
    private String msgId;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public static WxMpMassSendResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpMassSendResult.class);
    }

    @Override
    public String toString() {
        return "WxMassSendResult [errcode=" + errorCode + ", errmsg=" + errorMsg + ", msg_id=" + msgId + "]";
    }

}
