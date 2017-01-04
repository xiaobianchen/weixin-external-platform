package com.bingkun.weixin.api.dto.material;

import com.bingkun.weixin.common.util.ToStringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/4
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMaterialNewsBatchGetResult implements Serializable {
    private int totalCount;
    private int itemCount;
    private List<WxMaterialNewsBatchGetNewsItem> items;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxMaterialNewsBatchGetNewsItem {
        private String mediaId;
        private Date updateTime;
        private WxMpMaterialNews content;

        @Override
        public String toString() {
            return ToStringUtils.toSimpleString(this);
        }
    }
}
