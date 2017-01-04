package com.bingkun.weixin.api.dto;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * 语义理解查询用对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpSemanticQuery implements Serializable {

    private String query;
    private String category;
    private Float latitude;
    private Float longitude;
    private String city;
    private String region;
    private String appid;
    private String uid;

    public String toJson() {
        return WxMpGsonBuilder.create().toJson(this);
    }

}
