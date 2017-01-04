package com.bingkun.weixin.api.dto.datacube;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/2
 * 用户增减数据接口的返回JSON数据包
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxDataCubeUserSummary implements Serializable {
    private static final long serialVersionUID = -2336654489906694173L;

    private static final JsonParser JSON_PARSER = new JsonParser();

    private Date refDate;

    private Integer userSource;

    private Integer newUser;

    private Integer cancelUser;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static List<WxDataCubeUserSummary> fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(
                JSON_PARSER.parse(json).getAsJsonObject().get("list"),
                new TypeToken<List<WxDataCubeUserSummary>>() {
                }.getType());
    }
}
