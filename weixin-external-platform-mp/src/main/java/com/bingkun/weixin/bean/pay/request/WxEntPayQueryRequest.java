package com.bingkun.weixin.bean.pay.request;

import com.bingkun.weixin.common.annotation.Required;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 企业付款请求对象
 * Created by chenxiaobian on 2017/1/20.
 */
@XStreamAlias("xml")
public class WxEntPayQueryRequest extends WxPayBaseRequest {
    /**
     * <pre>
     * 商户号
     * mch_id
     * 是
     * 10000098
     * String(32)
     * 微信支付分配的商户号
     * </pre>
     */
    @XStreamAlias("mchid")
    private String mchId;

    /**
     * <pre>
     * 商户订单号
     * partner_trade_no
     * 是
     * 10000098201411111234567890
     * String
     * 商户订单号
     * </pre>
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    @Override
    public String getMchId() {
        return this.mchId;
    }

    @Override
    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPartnerTradeNo() {
        return this.partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
