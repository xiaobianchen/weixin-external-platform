package com.bingkun.weixin.api.dto.pay.result;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 微信支付结果共用属性类
 * Created by chenxiaobian on 2016-10-24.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public abstract class WxPayBaseResult {
    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    /**
     * 返回状态码
     */
    @XStreamAlias("return_code")
    protected String returnCode;

    /**
     * 返回信息
     */
    @XStreamAlias("return_msg")
    protected String returnMsg;

    /**
     * 业务结果
     */
    @XStreamAlias("result_code")
    private String resultCode;

    /**
     * 错误代码
     */
    @XStreamAlias("err_code")
    private String errCode;

    /**
     * 错误代码描述
     */
    @XStreamAlias("err_code_des")
    private String errCodeDes;

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
     * 随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XStreamAlias("sign")
    private String sign;
}
