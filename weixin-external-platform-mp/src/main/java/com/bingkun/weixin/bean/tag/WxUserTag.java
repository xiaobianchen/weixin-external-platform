package com.bingkun.weixin.bean.tag;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * 用户标签对象
 */
public class WxUserTag {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
