package com.bingkun.weixin.common.util.xml;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public class XStreamMediaIdConverter extends XStreamCDataConverter {
    @Override
    public String toString(Object obj) {
        return "<MediaId>" + super.toString(obj) + "</MediaId>";
    }
}
