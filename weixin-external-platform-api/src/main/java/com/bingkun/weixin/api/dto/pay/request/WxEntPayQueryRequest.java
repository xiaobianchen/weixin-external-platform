package com.bingkun.weixin.api.dto.pay.request;

import com.bingkun.weixin.common.annotation.Required;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 企业付款请求对象
 * 注释中各行每个字段描述对应如下：
 * Created by chenxiaobian on 2016/10/19.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxEntPayQueryRequest extends WxPayBaseRequest {
    /**
     * 商户号
     * 微信支付分配的商户号
     */
    @SuppressWarnings("hiding")
    @XStreamAlias("mchid")
    private String mchId;

    /**
     * 商户订单号
     * 商户订单号
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
