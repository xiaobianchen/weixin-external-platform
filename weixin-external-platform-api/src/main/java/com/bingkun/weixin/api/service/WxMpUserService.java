package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.result.WxMpUser;
import com.bingkun.weixin.api.dto.result.WxMpUserList;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/2.
 *
 * 用户管理相关操作接口
 */
public interface WxMpUserService {

    /**
     * 设置用户备注名
     *
     * @param openid 用户openid
     * @param remark 备注名
     */
    void userUpdateRemark(String openid, String remark) throws WxErrorException;

    /**
     * 获取用户基本信息（语言为默认的zh_CN 简体）
     *
     * @param openid 用户openid
     */
    WxMpUser userInfo(String openid) throws WxErrorException;

    /**
     * 获取用户基本信息
     *
     * @param openid 用户openid
     * @param lang   语言，zh_CN 简体(默认)，zh_TW 繁体，en 英语
     */
    WxMpUser userInfo(String openid, String lang) throws WxErrorException;

    /**
     * 获取用户基本信息列表
     *
     * @param openids 用户openid列表
     */
    List<WxMpUser> userInfoList(List<String> openids) throws WxErrorException;

    /**
     * 获取用户列表
     * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     *
     * @param nextOpenid 可选，第一个拉取的OPENID，null为从头开始拉取
     */
    WxMpUserList userList(String nextOpenid) throws WxErrorException;
}
