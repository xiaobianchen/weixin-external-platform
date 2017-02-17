package com.bingkun.weixin.bean.template;


import com.bingkun.weixin.common.util.ToStringUtils;
import com.bingkun.weixin.util.json.WxMpGsonBuilder;

import java.io.Serializable;

/**
 * Created by chenxiaobian on 2017/2/17
 */
public class WxMpTemplateIndustry implements Serializable {
    private static final long serialVersionUID = -7700398224795914722L;
    private Industry primaryIndustry;
    private Industry secondIndustry;

    public WxMpTemplateIndustry() {
    }

    public WxMpTemplateIndustry(Industry primaryIndustry, Industry secondIndustry) {
        this.primaryIndustry = primaryIndustry;
        this.secondIndustry = secondIndustry;
    }

    public static class Industry implements Serializable {
        private static final long serialVersionUID = -1707184885588012142L;
        private String id;
        private String firstClass;
        private String secondClass;

        public Industry() {
        }

        public Industry(String id) {
            this.id = id;
        }

        public Industry(String id, String firstClass, String secondClass) {
            this.id = id;
            this.firstClass = firstClass;
            this.secondClass = secondClass;
        }

        @Override
        public String toString() {
            return ToStringUtils.toSimpleString(this);
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstClass() {
            return this.firstClass;
        }

        public void setFirstClass(String firstClass) {
            this.firstClass = firstClass;
        }

        public String getSecondClass() {
            return this.secondClass;
        }

        public void setSecondClass(String secondClass) {
            this.secondClass = secondClass;
        }
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public static WxMpTemplateIndustry fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpTemplateIndustry.class);
    }

    public String toJson() {
        return WxMpGsonBuilder.create().toJson(this);
    }

    public Industry getPrimaryIndustry() {
        return this.primaryIndustry;
    }

    public void setPrimaryIndustry(Industry primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Industry getSecondIndustry() {
        return this.secondIndustry;
    }

    public void setSecondIndustry(Industry secondIndustry) {
        this.secondIndustry = secondIndustry;
    }
}
