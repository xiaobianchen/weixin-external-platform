package com.bingkun.weixin.api.dto.material;


import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterialArticleUpdate implements Serializable {

    private String mediaId;
    private int index;
    private WxMpMaterialNews.WxMpMaterialNewsArticle articles;

    public String toJson() {
        return WxMpGsonBuilder.create().toJson(this);
    }
}
