package com.bingkun.weixin.api.dto.pay;

import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/4
 * 订单支付状态回调
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayJsSDKCallback implements Serializable {
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String openid;
    private String is_subscribe;
    private String trade_type;
    private String bank_type;
    private String total_fee;
    private String fee_type;
    private String cash_fee;
    private String cash_fee_type;
    private String coupon_fee;
    private String coupon_count;
    private String coupon_batch_id_$n;
    private String coupon_id_$n;
    private String coupon_fee_$n;
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
