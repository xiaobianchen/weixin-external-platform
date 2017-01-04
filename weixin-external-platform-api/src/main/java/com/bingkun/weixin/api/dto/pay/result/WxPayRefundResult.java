package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1
 * 微信支付-申请退款返回结果
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayRefundResult extends WxPayBaseResult implements Serializable {
    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    @XStreamAlias("refund_id")
    private String refundId;

    @XStreamAlias("refund_channel")
    private String refundChannel;

    @XStreamAlias("refund_fee")
    private String refundFee;

    @XStreamAlias("total_fee")
    private String totalFee;

    @XStreamAlias("fee_type")
    private String feeType;

    @XStreamAlias("cash_fee")
    private String cashFee;

    @XStreamAlias("cash_refund_fee")
    private String cashRefundFee;

    @XStreamAlias("coupon_refund_fee")
    private String couponRefundFee;

    @XStreamAlias("coupon_refund_count")
    private String couponRefundCount;

    @XStreamAlias("coupon_refund_id")
    private String couponRefundId;
}
