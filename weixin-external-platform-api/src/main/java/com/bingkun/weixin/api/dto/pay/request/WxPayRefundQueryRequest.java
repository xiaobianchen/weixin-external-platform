package com.bingkun.weixin.api.dto.pay.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by chenxiaobian on 2016-11-24.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayRefundQueryRequest extends WxPayBaseRequest {
    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 签名类型
     */
    @XStreamAlias("sign_type")
    private String signType;

    /**
     * 微信订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 商户退款单号
     */
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    @XStreamAlias("refund_id")
    private String refundId;
}
