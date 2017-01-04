package com.bingkun.weixin.api.dto;

import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 * 微信卡券
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpCard implements Serializable {

    /**
     * 卡号
     */
    private String cardId;

    /**
     * 卡券有效期开始时间
     */
    private Long beginTime;

    /**
     * 卡券有效期结束时间
     */
    private Long endTime;

    /**
     * 卡券状态
     */
    private String userCardStatus;

    /**
     * 是否能消费
     */
    private Boolean canConsume;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
