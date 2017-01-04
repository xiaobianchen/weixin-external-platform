package com.bingkun.weixin.api.dto;

import com.bingkun.weixin.api.util.json.WxMpGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/2.
 * openid列表群发的消息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WxMpMassOpenIdsMessage implements Serializable {

    private List<String> toUsers = new ArrayList<>();
    private String msgType;
    private String content;
    private String mediaId;

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }

    /**
     * openid列表，最多支持10,000个
     */
    public List<String> getToUsers() {
        return this.toUsers;
    }

    /**
     * 添加openid，最多支持10,000个
     *
     * @param openid
     */
    public void addUser(String openid) {
        this.toUsers.add(openid);
    }

    /**
     * 提供set方法，方便客户端直接设置所有群发对象的openid列表
     *
     * @param toUsers
     */
    public void setToUsers(List<String> toUsers) {
        this.toUsers = toUsers;
    }

}
