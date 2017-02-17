package com.bingkun.weixin.bean.pay.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订单查询请求对象
 */
@XStreamAlias("xml")
public class WxPayOrderQueryRequest extends WxPayBaseRequest {

    /**
     * <pre>
     * 微信订单号
     * transaction_id
     * 二选一
     * String(32)
     * 1009660380201506130728806387
     * 微信的订单号，优先使用
     * </pre>
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * <pre>
     * 商户订单号
     * out_trade_no
     * 二选一
     * String(32)
     * 20150806125346
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     * </pre>
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
