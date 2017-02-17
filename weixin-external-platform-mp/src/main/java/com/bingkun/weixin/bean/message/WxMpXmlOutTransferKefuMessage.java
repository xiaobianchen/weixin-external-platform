package com.bingkun.weixin.bean.message;

import com.bingkun.weixin.common.constants.WxConsts;
import com.bingkun.weixin.common.util.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;


@XStreamAlias("xml")
public class WxMpXmlOutTransferKefuMessage extends WxMpXmlOutMessage {

    @XStreamAlias("TransInfo")
    protected TransInfo transInfo;

    public WxMpXmlOutTransferKefuMessage() {
        this.msgType = WxConsts.CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE;
    }

    public TransInfo getTransInfo() {
        return this.transInfo;
    }

    public void setTransInfo(TransInfo transInfo) {
        this.transInfo = transInfo;
    }

    @XStreamAlias("TransInfo")
    public static class TransInfo {

        @XStreamAlias("KfAccount")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String kfAccount;

        public String getKfAccount() {
            return this.kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }
}
