package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.List;

/**
 * Created by chenxiaobian on 2016-11-24.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayRefundQueryResult extends WxPayBaseResult {
    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

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
     * 订单金额
     */
    @XStreamAlias("total_fee")
    private Integer totalFee;

    /**
     * 应结订单金额
     */
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;

    /**
     * 货币种类
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;

    /**
     * 退款笔数
     */
    @XStreamAlias("refund_count")
    private Integer refundCount;

    private List<RefundRecord> refundRecords;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RefundRecord {
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

        /**
         * 退款渠道
         */
        @XStreamAlias("refund_channel")
        private String refundChannel;

        /**
         * 申请退款金额
         */
        @XStreamAlias("refund_fee")
        private String refundFee;

        /**
         * 退款金额
         */
        @XStreamAlias("settlement_refund_fee")
        private String settlementRefundFee;

        /**
         * 退款资金来源
         */
        @XStreamAlias("refund_account")
        private String refundAccount;

        /**
         * 代金券类型
         */
        @XStreamAlias("coupon_type")
        private String couponType;

        /**
         * 代金券退款金额
         */
        @XStreamAlias("coupon_refund_fee")
        private String couponRefundFee;

        /**
         * 退款代金券使用数量
         */
        @XStreamAlias("coupon_refund_count")
        private String couponRefundCount;

        private List<RefundCoupon> refundCoupons;

        /**
         * 退款状态
         */
        @XStreamAlias("refund_status")
        private String refundStatus;
        /**
         * 退款入账账户
         */
        @XStreamAlias("refund_recv_accout")
        private String refundRecvAccout;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class RefundCoupon {
            /**
             * 退款代金券批次ID
             */
            @XStreamAlias("coupon_refund_batch_id")
            private String couponRefundBatchId;

            /**
             * 退款代金券ID
             */
            @XStreamAlias("coupon_refund_id")
            private String couponRefundId;

            /**
             * 单个退款代金券支付金额
             */
            @XStreamAlias("coupon_refund_fee")
            private String couponRefundFee;
        }

    }
}

