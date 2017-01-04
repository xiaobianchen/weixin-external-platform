package com.bingkun.weixin.api.builder.outxml;

import com.bingkun.weixin.api.dto.message.WxMpXmlOutTransferKefuMessage;
import org.apache.commons.lang3.StringUtils;

/**
 * 客服消息builder
 */
public final class TransferCustomerServiceBuilder extends BaseBuilder<TransferCustomerServiceBuilder, WxMpXmlOutTransferKefuMessage> {
    private String kfAccount;

    public TransferCustomerServiceBuilder kfAccount(String kf) {
        this.kfAccount = kf;
        return this;
    }

    @Override
    public WxMpXmlOutTransferKefuMessage build() {
        WxMpXmlOutTransferKefuMessage m = new WxMpXmlOutTransferKefuMessage();
        setCommon(m);
        if (StringUtils.isNotBlank(this.kfAccount)) {
            WxMpXmlOutTransferKefuMessage.TransInfo transInfo = new WxMpXmlOutTransferKefuMessage.TransInfo();
            transInfo.setKfAccount(this.kfAccount);
            m.setTransInfo(transInfo);
        }
        return m;
    }
}
