package com.bingkun.weixin.api.dto.message;

import com.bingkun.weixin.api.builder.kefu.*;
import com.bingkun.weixin.api.builder.outxml.TransferCustomerServiceBuilder;
import com.bingkun.weixin.api.service.WxMpConfigStorage;
import com.bingkun.weixin.api.util.crypto.WxMpCryptUtil;
import com.bingkun.weixin.api.util.xml.XStreamTransformer;
import com.bingkun.weixin.common.util.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@XStreamAlias("xml")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public abstract class WxMpXmlOutMessage implements Serializable {

    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String toUserName;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String fromUserName;

    @XStreamAlias("CreateTime")
    protected Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String msgType;

    public String toXml() {
        return XStreamTransformer.toXml((Class<WxMpXmlOutMessage>) this.getClass(), this);
    }

    /**
     * 转换成加密的xml格式
     */
    public String toEncryptedXml(WxMpConfigStorage wxMpConfigStorage) {
        String plainXml = toXml();
        WxMpCryptUtil pc = new WxMpCryptUtil(wxMpConfigStorage);
        return pc.encrypt(plainXml);
    }

    /**
     * 获得文本消息builder
     */
    public static TextBuilder TEXT() {
        return new TextBuilder();
    }

    /**
     * 获得图片消息builder
     */
    public static ImageBuilder IMAGE() {
        return new ImageBuilder();
    }

    /**
     * 获得语音消息builder
     */
    public static VoiceBuilder VOICE() {
        return new VoiceBuilder();
    }

    /**
     * 获得视频消息builder
     */
    public static VideoBuilder VIDEO() {
        return new VideoBuilder();
    }

    /**
     * 获得音乐消息builder
     */
    public static MusicBuilder MUSIC() {
        return new MusicBuilder();
    }

    /**
     * 获得图文消息builder
     */
    public static NewsBuilder NEWS() {
        return new NewsBuilder();
    }

    /**
     * 获得客服消息builder
     */
    public static TransferCustomerServiceBuilder TRANSFER_CUSTOMER_SERVICE() {
        return new TransferCustomerServiceBuilder();
    }
}
