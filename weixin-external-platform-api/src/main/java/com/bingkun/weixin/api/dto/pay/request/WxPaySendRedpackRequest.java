package com.bingkun.weixin.api.dto.pay.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 发送红包请求参数对象
 * Created by chenxiaobian on 2016/9/24.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPaySendRedpackRequest {
    /**
     * 商户订单号（每个订单号必须唯一)
     */
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    /**
     * send_name
     * 商户名称
     * 红包发送者名称
     */
    @XStreamAlias("send_name")
    private String sendName;

    /**
     * re_openid
     * 接受红包的用户   用户在wxappid下的openid
     */
    @XStreamAlias("re_openid")
    private String reOpenid;

    /**
     * total_amount
     * 红包总额
     */
    @XStreamAlias("total_amount")
    private Integer totalAmount;

    /**
     * total_num
     * 红包发放总人数
     */
    @XStreamAlias("total_num")
    private Integer totalNum;

    /**
     * amt_type
     * 红包金额设置方式
     * ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额
     * 裂变红包必填
     */
    @XStreamAlias("amt_type")
    private String amtType;

    /**
     * wishing
     * 红包祝福语
     */
    @XStreamAlias("wishing")
    private String wishing;

    /**
     * client_ip
     * 服务器Ip地址
     * 调用接口的机器Ip地址
     */
    @XStreamAlias("client_ip")
    private String clientIp;

    /**
     * act_name
     * 活动名称
     */
    @XStreamAlias("act_name")
    private String actName;

    /**
     * remark
     * 备注
     */
    @XStreamAlias("remark")
    private String remark;

    /**
     * wxappid
     * 微信分配的公众账号ID（企业号corpid即为此appId）。接口传入的所有appid应该为公众号的appid（在mp.weixin.qq.com申请的），不能为APP的appid（在open.weixin.qq.com申请的）
     */
    @XStreamAlias("wxappid")
    private String wxAppid;

    /**
     * mch_id
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * nonce_str
     * 随机字符串，不长于32位
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XStreamAlias("sign")
    private String sign;

    /**
     * scene_id
     * 场景id
     */
    @XStreamAlias("scene_id")
    private String sceneId;

    /**
     * risk_info
     */
    @XStreamAlias("risk_info")
    private String riskInfo;

    /**
     * consume_mch_id
     * 资金授权商户号
     * 资金授权商户号
     * 服务商替特约商户发放时使用
     * 非必填字段
     */
    @XStreamAlias("consume_mch_id")
    private String consumeMchId;
}
