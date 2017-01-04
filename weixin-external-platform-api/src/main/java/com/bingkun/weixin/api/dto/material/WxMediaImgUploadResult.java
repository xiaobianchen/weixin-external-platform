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
public class WxMediaImgUploadResult implements Serializable {
  private String url;

  public static WxMediaImgUploadResult fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(json, WxMediaImgUploadResult.class);
  }
}
