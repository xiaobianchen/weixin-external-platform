package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1
 * 微信支付-申请退款返回结果
 */
@XStreamAlias("xml")
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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee(String cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }

    public String getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee(String couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
    }

    public String getCouponRefundCount() {
        return couponRefundCount;
    }

    public void setCouponRefundCount(String couponRefundCount) {
        this.couponRefundCount = couponRefundCount;
    }

    public String getCouponRefundId() {
        return couponRefundId;
    }

    public void setCouponRefundId(String couponRefundId) {
        this.couponRefundId = couponRefundId;
    }
}
