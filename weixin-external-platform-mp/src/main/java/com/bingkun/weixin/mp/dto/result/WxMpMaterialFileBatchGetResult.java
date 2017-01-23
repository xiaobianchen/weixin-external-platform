package com.bingkun.weixin.mp.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/1.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterialFileBatchGetResult implements Serializable {

    private int totalCount;
    private int itemCount;
    private List<WxMaterialFileBatchGetNewsItem> items;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxMaterialFileBatchGetNewsItem {
        private String mediaId;
        private Date updateTime;
        private String name;
        private String url;
    }
}
