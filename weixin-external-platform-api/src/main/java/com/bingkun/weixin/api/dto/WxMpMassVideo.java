package com.bingkun.weixin.api.dto;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 14/1/4
 * 群发时用到的视频素材
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassVideo implements Serializable {

    private String mediaId;
    private String title;
    private String description;

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
