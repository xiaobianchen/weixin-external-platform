package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/4
 * 向微信用户个人发现金红包返回结果
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPaySendRedpackResult extends WxPayBaseResult implements Serializable {

    @XStreamAlias("mch_billno")
    private String mchBillno;

    @XStreamAlias("wxappid")
    private String wxappid;

    @XStreamAlias("re_openid")
    private String reOpenid;

    @XStreamAlias("total_amount")
    private int totalAmount;

    @XStreamAlias("send_time")
    private String sendTime;

    @XStreamAlias("send_listid")
    private String sendListid;
}
