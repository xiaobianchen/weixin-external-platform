package com.bingkun.weixin.bean.device;


import com.bingkun.weixin.common.util.json.WxGsonBuilder;

/**
 * Created by chenxiaobian on 2017/1/1.
 */
public abstract class AbstractDeviceBean {
    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }
}
