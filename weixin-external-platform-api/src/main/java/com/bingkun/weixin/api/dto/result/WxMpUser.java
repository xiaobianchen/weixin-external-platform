package com.bingkun.weixin.api.dto.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/4
 * 微信用户信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpUser implements Serializable {

    private Boolean subscribe;
    private String openId;
    private String nickname;
    private String sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headImgUrl;
    private Long subscribeTime;
    private String unionId;
    private Integer sexId;
    private String remark;
    private Integer groupId;
    private Integer[] tagIds;

    public static WxMpUser fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpUser.class);
    }

    public static List<WxMpUser> fromJsonList(String json) {
        Type collectionType = new TypeToken<List<WxMpUser>>() {
        }.getType();
        Gson gson = WxMpGsonBuilder.INSTANCE.create();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        return gson.fromJson(jsonObject.get("user_info_list"), collectionType);
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

}
