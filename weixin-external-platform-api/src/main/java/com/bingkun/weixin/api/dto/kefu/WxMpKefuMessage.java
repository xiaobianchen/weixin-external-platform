package com.bingkun.weixin.api.dto.kefu;

import com.bingkun.weixin.api.builder.kefu.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/2
 * 客服消息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpKefuMessage implements Serializable {

    private String toUser;
    private String msgType;
    private String content;
    private String mediaId;
    private String thumbMediaId;
    private String title;
    private String description;
    private String musicUrl;
    private String hqMusicUrl;
    private String kfAccount;
    private String cardId;
    private String mpNewsMediaId;
    private List<WxArticle> articles = new ArrayList<>();

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
     * 获得图文消息（点击跳转到外链）builder
     */
    public static NewsBuilder NEWS() {
        return new NewsBuilder();
    }

    /**
     * 获得图文消息（点击跳转到图文消息页面）builder
     */
    public static MpNewsBuilder MPNEWS() {
        return new MpNewsBuilder();
    }

    /**
     * 获得卡券消息builder
     */
    public static WxCardBuilder WXCARD() {
        return new WxCardBuilder();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WxArticle {
        private String title;
        private String description;
        private String url;
        private String picUrl;
    }
}
