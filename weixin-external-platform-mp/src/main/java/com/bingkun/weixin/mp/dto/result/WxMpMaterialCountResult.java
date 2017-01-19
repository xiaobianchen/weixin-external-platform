package com.bingkun.weixin.mp.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian 17/1/19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterialCountResult implements Serializable {

    private int voiceCount;
    private int videoCount;
    private int imageCount;
    private int newsCount;
}

