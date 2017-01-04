package com.bingkun.weixin.api.dto.material;

import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterialFileBatchGetResult implements Serializable {
    private int totalCount;
    private int itemCount;
    private List<WxMaterialFileBatchGetNewsItem> items;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxMaterialFileBatchGetNewsItem {
        private String mediaId;
        private Date updateTime;
        private String name;
        private String url;

        @Override
        public String toString() {
            return ToStringUtils.toSimpleString(this);
        }
    }
}
