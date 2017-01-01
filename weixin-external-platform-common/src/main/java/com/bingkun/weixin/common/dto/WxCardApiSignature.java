package com.bingkun.weixin.common.dto;

import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 * 卡券Api签名
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxCardApiSignature implements Serializable {

    private String appId;

    private String cardId;

    private String cardType;

    private String locationId;

    private String code;

    private String openId;

    private Long timestamp;

    private String nonceStr;

    private String signature;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
