package com.bingkun.weixin.api.dto.result;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpUserBlacklistGetResult implements Serializable {
    protected int total = -1;
    protected int count = -1;
    protected List<String> openidList = new ArrayList<>();
    protected String nextOpenid;

    public static WxMpUserBlacklistGetResult fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpUserBlacklistGetResult.class);
    }

    @Override
    public String toString() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
