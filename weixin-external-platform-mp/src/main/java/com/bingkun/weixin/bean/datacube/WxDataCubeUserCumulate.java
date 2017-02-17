package com.bingkun.weixin.bean.datacube;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxiaobian on 2016/8/24.
 * 累计用户数据接口的返回JSON数据包
 */
public class WxDataCubeUserCumulate implements Serializable {

    private static final JsonParser JSON_PARSER = new JsonParser();

    private static final long serialVersionUID = -3570981300225093657L;

    private Date refDate;

    private Integer cumulateUser;

    public Date getRefDate() {
        return this.refDate;
    }

    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    public Integer getCumulateUser() {
        return this.cumulateUser;
    }

    public void setCumulateUser(Integer cumulateUser) {
        this.cumulateUser = cumulateUser;
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static List<WxDataCubeUserCumulate> fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(
                JSON_PARSER.parse(json).getAsJsonObject().get("list"),
                new TypeToken<List<WxDataCubeUserCumulate>>() {
                }.getType());
    }
}
