package com.bingkun.weixin.api.dto.material;


import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterialCountResult implements Serializable {
    private int voiceCount;
    private int videoCount;
    private int imageCount;
    private int newsCount;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}

