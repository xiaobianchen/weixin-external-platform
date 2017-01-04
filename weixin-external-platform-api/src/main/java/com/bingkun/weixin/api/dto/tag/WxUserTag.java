package com.bingkun.weixin.api.dto.tag;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * 用户标签对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxUserTag implements Serializable{
    /**
     * id	标签id，由微信分配
     */
    private Long id;

    /**
     * name	标签名，UTF8编码
     */
    private String name;

    /**
     * count 此标签下粉丝数
     */
    private Integer count;

    public static WxUserTag fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(
                new JsonParser().parse(json).getAsJsonObject().get("tag"),
                WxUserTag.class);
    }

    public static List<WxUserTag> listFromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(
                new JsonParser().parse(json).getAsJsonObject().get("tags"),
                new TypeToken<List<WxUserTag>>() {
                }.getType());
    }

    public String toJson() {
        return WxMpGsonBuilder.create().toJson(this);
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
