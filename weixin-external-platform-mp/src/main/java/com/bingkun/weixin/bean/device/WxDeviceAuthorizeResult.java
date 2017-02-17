package com.bingkun.weixin.bean.device;


import com.bingkun.weixin.common.util.json.WxGsonBuilder;

import java.util.List;

/**
 * Created by chenxiaobian on 2016/12/10.
 */
public class WxDeviceAuthorizeResult extends AbstractDeviceBean{
  private List<BaseResp> resp;

  public static WxDeviceAuthorizeResult fromJson(String response) {
    return WxGsonBuilder.create().fromJson(response, WxDeviceAuthorizeResult.class);
  }

  public List<BaseResp> getResp() {
    return resp;
  }

  public void setResp(List<BaseResp> resp) {
    this.resp = resp;
  }
}
