package com.bingkun.weixin.common.dto.result;

import com.bingkun.weixin.common.util.json.WxGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 17/1/1.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxError implements Serializable {

    private int errorCode;
    private String errorMsg;
    private String json;

    public static WxError fromJson(String json) {
        WxError error = WxGsonBuilder.create().fromJson(json, WxError.class);
        return error;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int errorCode;
        private String errorMsg;

        public Builder setErrorCode(int errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public WxError build() {
            WxError wxError = new WxError();
            wxError.setErrorCode(this.errorCode);
            wxError.setErrorMsg(this.errorMsg);
            return wxError;
        }

    }


}
