package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.List;

/**
 * 查询订单 返回结果对象
 * Created by chenxiaobian on 2016-10-24.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayOrderQueryResult extends WxPayBaseResult {

    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 用户标识
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * 是否关注公众账号
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    @XStreamAlias("is_subscribe")
    private String isSubscribe;

    /**
     * 交易类型
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 交易状态
     */
    @XStreamAlias("trade_state")
    private String tradeState;

    /**
     * 付款银行
     */
    @XStreamAlias("bank_type")
    private String bankType;

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
     * <pre>现金支付金额
     * cash_fee
     * 是
     * Int
     * 100
     * 现金支付金额订单现金支付金额，详见支付金额
     * </pre>
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;

    /**
     * 现金支付货币类型
     */
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    /**
     * 代金券金额
     */
    @XStreamAlias("coupon_fee")
    private Integer couponFee;

    /**
     * 代金券使用数量
     */
    @XStreamAlias("coupon_count")
    private Integer couponCount;

    private List<Coupon> coupons;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Coupon {
        /**
         * 代金券类型
         */
        private String couponType;

        /**
         * 代金券ID
         */
        private String couponId;

        /**
         * 单个代金券支付金额
         */
        private Integer couponFee;
    }

    /**
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 附加数据
     */
    @XStreamAlias("attach")
    private String attach;

    /**
     * 支付完成时间
     */
    @XStreamAlias("time_end")
    private String timeEnd;

    /**
     * 交易状态描述
     */
    @XStreamAlias("trade_state_desc")
    private String tradeStateDesc;
}
