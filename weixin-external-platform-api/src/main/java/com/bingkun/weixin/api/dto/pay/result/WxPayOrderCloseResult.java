package com.bingkun.weixin.api.dto.pay.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * 关闭订单结果对象类
 * Created by chenxiaobian on 2017-1-4.
 */
@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayOrderCloseResult extends WxPayBaseResult {

    /**
     * 业务结果描述
     */
    @XStreamAlias("result_msg")
    private String resultMsg;
}
