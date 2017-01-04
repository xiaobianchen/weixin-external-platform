package com.bingkun.weixin.api.service;


import com.bingkun.weixin.api.dto.tag.WxTagListUser;
import com.bingkun.weixin.api.dto.tag.WxUserTag;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.util.List;

/**
 * Created by chenxiaobian on 2016/9/2.
 *
 * 用户标签管理相关接口
 */
public interface WxMpUserTagService {

    /**
     * 创建标签
     * 一个公众号，最多可以创建100个标签。
     *
     * @param name 标签名字（30个字符以内）
     */
    WxUserTag tagCreate(String name) throws WxErrorException;

    /**
     * 获取公众号已创建的标签
     */
    List<WxUserTag> tagGet() throws WxErrorException;

    /**
     * 编辑标签
     */
    Boolean tagUpdate(Long tagId, String name) throws WxErrorException;

    /**
     * 删除标签
     */
    Boolean tagDelete(Long tagId) throws WxErrorException;

    /**
     * 获取标签下粉丝列表
     */
    WxTagListUser tagListUser(Long tagId, String nextOpenid)
            throws WxErrorException;

    /**
     * 批量为用户打标签
     */
    boolean batchTagging(Long tagId, String[] openids) throws WxErrorException;

    /**
     * 批量为用户取消标签
     */
    boolean batchUntagging(Long tagId, String[] openids) throws WxErrorException;

    /**
     * 获取用户身上的标签列表
     *
     * @return 标签Id的列表
     */
    List<Long> userTagList(String openid) throws WxErrorException;

}
