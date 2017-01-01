package com.bingkun.weixin.common.dto.menu;


import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMenuButton {

    private String type;
    private String name;
    private String key;
    private String url;
    private String mediaId;

    private List<WxMenuButton> subButtons = new ArrayList<>();

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
