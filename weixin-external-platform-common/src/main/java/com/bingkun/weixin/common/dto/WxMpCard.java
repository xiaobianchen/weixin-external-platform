package com.bingkun.weixin.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/2/14.
 * <p>
 * 微信卡券
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpCard implements Serializable {

    /**
     * 卡券ID
     */
    private String cardId;

    /**
     * 起始使用时间
     */
    private Long beginTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 卡券状态
     * GIFT_TIMEOUT  转赠超时
     * DELETE              已删除
     * UNAVAILABLE   已失效
     */
    private String userCardStatus;

    /**
     * 是否可以核销，true为可以核销，false为不可核销
     */
    private Boolean canConsume;
}
