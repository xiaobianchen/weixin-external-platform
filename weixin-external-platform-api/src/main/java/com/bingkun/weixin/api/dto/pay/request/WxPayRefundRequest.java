package com.bingkun.weixin.api.dto.pay.request;

import com.bingkun.weixin.common.annotation.Required;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 微信支付-申请退款请求参数
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayRefundRequest {
    /**
     * 公众账号ID
     */
    @XStreamAlias("appid")
    private String appid;

    /**
     * 商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XStreamAlias("sign")
    private String sign;

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
    @Required
    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    /**
     * 订单金额
     */
    @Required
    @XStreamAlias("total_fee")
    private Integer totalFee;

    /**
     * 退款金额
     */
    @Required
    @XStreamAlias("refund_fee")
    private Integer refundFee;

    /**
     * 货币种类
     */
    @XStreamAlias("refund_fee_type")
    private String refundFeeType;

    /**
     * 操作员
     */
    //@Required
    @XStreamAlias("op_user_id")
    private String opUserId;

    /**
     * 退款资金来源
     */
    @XStreamAlias("refund_account")
    private String refundAccount;
}
