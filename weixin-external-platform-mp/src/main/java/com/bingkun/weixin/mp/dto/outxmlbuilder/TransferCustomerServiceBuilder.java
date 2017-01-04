package com.bingkun.weixin.mp.dto.outxmlbuilder;


import com.bingkun.weixin.mp.dto.WxMpXmlOutTransferCustomerServiceMessage;

/**
 * 客服消息builder
 */
public final class TransferCustomerServiceBuilder extends BaseBuilder<TransferCustomerServiceBuilder, WxMpXmlOutTransferCustomerServiceMessage> {
    private String kfAccount;

    public TransferCustomerServiceBuilder kfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
        return this;
    }


    public WxMpXmlOutTransferCustomerServiceMessage build() {
        WxMpXmlOutTransferCustomerServiceMessage m = new WxMpXmlOutTransferCustomerServiceMessage();
        setCommon(m);
        m.setKfAccount(kfAccount);
        return m;
    }
}
