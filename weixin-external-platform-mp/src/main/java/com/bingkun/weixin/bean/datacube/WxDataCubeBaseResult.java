package com.bingkun.weixin.bean.datacube;

import com.bingkun.weixin.common.util.ToStringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * 统计接口的共用属性类
 * Created by chenxiaobian on 2016/8/24.
 */
public class WxDataCubeBaseResult {
  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  /**
   * ref_date
   * 数据的日期，需在begin_date和end_date之间
   */
  @SerializedName("ref_date")
  private String refDate;

  public String getRefDate() {
    return this.refDate;
  }

  public void setRefDate(String refDate) {
    this.refDate = refDate;
  }

}
