package com.bingkun.weixin.mp.dto.result;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenxiaobian on 17/1/20
 * 累计用户数据接口的返回JSON数据包
 */
public class WxMpUserCumulate implements Serializable {

    private Date refDate;

    private Integer cumulateUser;

    public Date getRefDate() {
        return refDate;
    }

    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    public Integer getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(Integer cumulateUser) {
        this.cumulateUser = cumulateUser;
    }

    @Override
    public String toString() {
        return "WxMpUserCumulate{" +
                "refDate=" + refDate +
                ", cumulateUser=" + cumulateUser +
                '}';
    }
}
