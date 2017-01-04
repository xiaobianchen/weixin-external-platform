package com.bingkun.weixin.api.dto.result;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/4
 * 关注者列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpUserList implements Serializable {

    protected int total = -1;
    protected int count = -1;
    protected List<String> openIds = new ArrayList<>();
    protected String nextOpenId;

    public static WxMpUserList fromJson(String json) {
        return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpUserList.class);
    }

    @Override
    public String toString() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }
}
