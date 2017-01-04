package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 企业付款查询返回结果
 * Created by chenxiaobian on 2016/10/19.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxEntPayQueryResult extends WxPayBaseResult {

    /**
     * 商户订单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 付款单号
     */
    @XStreamAlias("detail_id")
    private String detailId;

    /**
     * 转账状态
     */
    @XStreamAlias("status")
    private String status;

    /**
     * 失败原因
     */
    @XStreamAlias("reason")
    private String reason;

    /**
     * 收款用户openid
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * 收款用户姓名
     */
    @XStreamAlias("transfer_name")
    private String transferName;

    /**
     * 付款金额
     */
    @XStreamAlias("payment_amount")
    private Integer paymentAmount;

    /**
     * 转账时间
     */
    @XStreamAlias("transfer_time")
    private String transferTime;

    /**
     * 付款描述
     */
    @XStreamAlias("desc")
    private String desc;
}
