package com.bingkun.weixin.api.dto.pay.request;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 企业付款请求对象
 * 注释中各行每个字段描述对应如下：
 * Created by chenxiaobian on 2016/10/02.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxEntPayRequest {
    /**
     * 公众账号appid
     * 微信分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("mch_appid")
    private String mchAppid;

    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @XStreamAlias("mchid")
    private String mchId;

    /**
     * 设备号
     * 微信支付分配的终端设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 随机字符串
     * 随机字符串，不长于32位
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     * 签名，详见签名算法
     */
    @XStreamAlias("sign")
    private String sign;

    /**
     * 商户订单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 需保持唯一性 用户openid
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * 校验用户姓名选项
     */
    @XStreamAlias("check_name")
    private String checkName;

    /**
     * 收款用户姓名
     */
    @XStreamAlias("re_user_name")
    private String reUserName;

    /**
     * 金额
     */
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * 企业付款描述信息
     */
    @XStreamAlias("desc")
    private String description;

    /**
     * 调用接口的机器Ip地址
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
