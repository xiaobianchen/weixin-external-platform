package com.bingkun.weixin.api.dto.pay.request;

import com.bingkun.weixin.common.annotation.Required;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 统一下单请求参数对象
 * Created by chenxiaobian on 2016/9/25.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayUnifiedOrderRequest extends WxPayBaseRequest {

    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 商品描述
     */
    @Required
    @XStreamAlias("body")
    private String body;

    /**
     * 商品详情
     */
    @XStreamAlias("detail")
    private String detail;

    /**
     * 附加数据
     */
    @XStreamAlias("attach")
    private String attach;

    /**
     * 商户订单号
     */
    @Required
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 总金额
     */
    @Required
    @XStreamAlias("total_fee")
    private Integer totalFee;

    /**
     * 终端IP
     */
    @Required
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 交易起始时间
     */
    @XStreamAlias("time_start")
    private String timeStart;

    /**
     * 交易结束时间
     */
    @XStreamAlias("time_expire")
    private String timeExpire;

    /**
     * 商品标记
     */
    @XStreamAlias("goods_tag")
    private String goodsTag;

    /**
     * 通知地址
     */
    @Required
    @XStreamAlias("notify_url")
    private String notifyURL;

    /**
     * 交易类型
     */
    @Required
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 商品Id
     */
    @XStreamAlias("product_id")
    private String productId;

    /**
     * 指定支付方式
     */
    @XStreamAlias("limit_pay")
    private String limitPay;

    /**
     * 用户标识
     */
    @XStreamAlias("openid")
    private String openid;

    public static class WxUnifiedOrderRequestBuilder {
        private String appid;
        private String mchId;
        private String deviceInfo;
        private String nonceStr;
        private String sign;
        private String body;
        private String detail;
        private String attach;
        private String outTradeNo;
        private String feeType;
        private Integer totalFee;
        private String spbillCreateIp;
        private String timeStart;
        private String timeExpire;
        private String goodsTag;
        private String notifyURL;
        private String tradeType;
        private String productId;
        private String limitPay;
        private String openid;

        public WxUnifiedOrderRequestBuilder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public WxUnifiedOrderRequestBuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public WxUnifiedOrderRequestBuilder deviceInfo(String deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        public WxUnifiedOrderRequestBuilder nonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this;
        }

        public WxUnifiedOrderRequestBuilder sign(String sign) {
            this.sign = sign;
            return this;
        }

        public WxUnifiedOrderRequestBuilder body(String body) {
            this.body = body;
            return this;
        }

        public WxUnifiedOrderRequestBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public WxUnifiedOrderRequestBuilder attach(String attach) {
            this.attach = attach;
            return this;
        }

        public WxUnifiedOrderRequestBuilder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public WxUnifiedOrderRequestBuilder feeType(String feeType) {
            this.feeType = feeType;
            return this;
        }

        public WxUnifiedOrderRequestBuilder totalFee(Integer totalFee) {
            this.totalFee = totalFee;
            return this;
        }

        public WxUnifiedOrderRequestBuilder spbillCreateIp(String spbillCreateIp) {
            this.spbillCreateIp = spbillCreateIp;
            return this;
        }

        public WxUnifiedOrderRequestBuilder timeStart(String timeStart) {
            this.timeStart = timeStart;
            return this;
        }

        public WxUnifiedOrderRequestBuilder timeExpire(String timeExpire) {
            this.timeExpire = timeExpire;
            return this;
        }

        public WxUnifiedOrderRequestBuilder goodsTag(String goodsTag) {
            this.goodsTag = goodsTag;
            return this;
        }

        public WxUnifiedOrderRequestBuilder notifyURL(String notifyURL) {
            this.notifyURL = notifyURL;
            return this;
        }

        public WxUnifiedOrderRequestBuilder tradeType(String tradeType) {
            this.tradeType = tradeType;
            return this;
        }

        public WxUnifiedOrderRequestBuilder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public WxUnifiedOrderRequestBuilder limitPay(String limitPay) {
            this.limitPay = limitPay;
            return this;
        }

        public WxUnifiedOrderRequestBuilder openid(String openid) {
            this.openid = openid;
            return this;
        }

        public WxUnifiedOrderRequestBuilder from(WxPayUnifiedOrderRequest origin) {
            this.appid(origin.appid);
            this.mchId(origin.mchId);
            this.deviceInfo(origin.deviceInfo);
            this.nonceStr(origin.nonceStr);
            this.sign(origin.sign);
            this.body(origin.body);
            this.detail(origin.detail);
            this.attach(origin.attach);
            this.outTradeNo(origin.outTradeNo);
            this.feeType(origin.feeType);
            this.totalFee(origin.totalFee);
            this.spbillCreateIp(origin.spbillCreateIp);
            this.timeStart(origin.timeStart);
            this.timeExpire(origin.timeExpire);
            this.goodsTag(origin.goodsTag);
            this.notifyURL(origin.notifyURL);
            this.tradeType(origin.tradeType);
            this.productId(origin.productId);
            this.limitPay(origin.limitPay);
            this.openid(origin.openid);
            return this;
        }

        public WxPayUnifiedOrderRequest build() {
            WxPayUnifiedOrderRequest m = new WxPayUnifiedOrderRequest();
            m.appid = this.appid;
            m.mchId = this.mchId;
            m.deviceInfo = this.deviceInfo;
            m.nonceStr = this.nonceStr;
            m.sign = this.sign;
            m.body = this.body;
            m.detail = this.detail;
            m.attach = this.attach;
            m.outTradeNo = this.outTradeNo;
            m.feeType = this.feeType;
            m.totalFee = this.totalFee;
            m.spbillCreateIp = this.spbillCreateIp;
            m.timeStart = this.timeStart;
            m.timeExpire = this.timeExpire;
            m.goodsTag = this.goodsTag;
            m.notifyURL = this.notifyURL;
            m.tradeType = this.tradeType;
            m.productId = this.productId;
            m.limitPay = this.limitPay;
            m.openid = this.openid;
            return m;
        }
    }

}
