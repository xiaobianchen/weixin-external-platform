package com.bingkun.weixin.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 * jspai 签名
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxJsapiSignature implements Serializable {

    private String appid;

    private String noncestr;

    private long timestamp;

    private String url;

    private String signature;
}
