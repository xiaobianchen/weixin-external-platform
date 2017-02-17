package com.bingkun.weixin.bean.datacube;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户增减数据接口的返回JSON数据包
 */
public class WxDataCubeUserSummary implements Serializable {
  private static final long serialVersionUID = -2336654489906694173L;

  private static final JsonParser JSON_PARSER = new JsonParser();

  private Date refDate;

  private Integer userSource;

  private Integer newUser;

  private Integer cancelUser;

  public Date getRefDate() {
    return this.refDate;
  }

  public void setRefDate(Date refDate) {
    this.refDate = refDate;
  }

  public Integer getUserSource() {
    return this.userSource;
  }

  public void setUserSource(Integer userSource) {
    this.userSource = userSource;
  }

  public Integer getNewUser() {
    return this.newUser;
  }

  public void setNewUser(Integer newUser) {
    this.newUser = newUser;
  }

  public Integer getCancelUser() {
    return this.cancelUser;
  }

  public void setCancelUser(Integer cancelUser) {
    this.cancelUser = cancelUser;
  }

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
