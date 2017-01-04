package com.bingkun.weixin.api.dto.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian 17/1/4
 * 语义理解查询结果对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpSemanticQueryResult implements Serializable {

    private String query;
    private String type;
    private String semantic;
    private String result;
    private String answer;
    private String text;

    public static WxMpSemanticQueryResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpSemanticQueryResult.class);
    }

}
