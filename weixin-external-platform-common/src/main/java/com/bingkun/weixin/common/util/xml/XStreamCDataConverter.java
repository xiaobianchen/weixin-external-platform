package com.bingkun.weixin.common.util.xml;

import com.thoughtworks.xstream.converters.basic.StringConverter;
/**
 * Created by chenxiaobian on 17/1/1.
 */
public class XStreamCDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return "<![CDATA[" + super.toString(obj) + "]]>";
    }

}
