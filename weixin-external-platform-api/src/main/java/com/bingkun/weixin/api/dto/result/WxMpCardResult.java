package com.bingkun.weixin.api.dto.result;

import com.bingkun.weixin.api.dto.WxMpCard;
import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/4
 * 卡券查询Code，核销Code接口返回结果
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpCardResult implements Serializable {

    private String errorCode;

    private String errorMsg;

    private String openId;

    private WxMpCard card;

    private String userCardStatus;

    private Boolean canConsume;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
