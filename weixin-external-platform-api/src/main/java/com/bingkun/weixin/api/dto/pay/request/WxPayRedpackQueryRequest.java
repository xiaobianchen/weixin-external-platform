package com.bingkun.weixin.api.dto.pay.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * Created by chenxiaobian on 2016-11-28.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayRedpackQueryRequest extends WxPayBaseRequest {
    /**
     * 商户订单号
     */
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    /**
     * 订单类型
     */
    @XStreamAlias("bill_type")
    private String billType;
}
