package com.bingkun.weixin.common.dto.menu;

import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMenuRule implements Serializable {
    private String tagId;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String clientPlatformType;
    private String language;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
