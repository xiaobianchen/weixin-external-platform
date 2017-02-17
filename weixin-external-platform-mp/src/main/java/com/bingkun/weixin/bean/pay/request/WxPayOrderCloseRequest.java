package com.bingkun.weixin.bean.pay.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 关闭订单请求对象类
 */
@XStreamAlias("xml")
public class WxPayOrderCloseRequest extends WxPayBaseRequest {

    /**
     * 商户订单号
     * out_trade_no
     * 二选一
     * String(32)
     * 20150806125346
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    public String getOutTradeNo() {
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

}
