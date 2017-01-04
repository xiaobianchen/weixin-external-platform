package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 企业付款返回结果
 * Created by chenxiaobian on 2016/10/02.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxEntPayResult extends WxPayBaseResult {

    /**
     * 商户appid
     */
    @XStreamAlias("mch_appid")
    private String mchAppid;

    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 商户订单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 微信订单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 微信支付成功时间
     */
    @XStreamAlias("payment_time")
    private String paymentTime;
}
