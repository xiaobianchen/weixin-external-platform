package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by chenxiaobian on 17/1/4
 * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"返回的结果
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayUnifiedOrderResult extends WxPayBaseResult {

    @XStreamAlias("prepay_id")
    private String prepayId;

    @XStreamAlias("trade_type")
    private String tradeType;

    @XStreamAlias("code_url")
    private String codeURL;
}
