package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.kefu.WxMpKefuMessage;
import com.bingkun.weixin.api.dto.kefu.request.WxMpKfAccountRequest;
import com.bingkun.weixin.api.dto.kefu.result.*;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.io.File;
import java.util.Date;

/**
 * Created by chenxiaobian on 17/1/1.
 * 客服接口
 */
public interface WxMpKefuService {

  /**
   * 发送客服消息
   */
  boolean sendKefuMessage(WxMpKefuMessage message) throws WxErrorException;

  //*******************客服管理接口***********************//

  /**
   * 获取客服基本信息
   */
  WxMpKfList kfList() throws WxErrorException;

  /**
   * 获取在线客服接待信息
   */
  WxMpKfOnlineList kfOnlineList() throws WxErrorException;

  /**
   * 添加客服账号
   */
  boolean kfAccountAdd(WxMpKfAccountRequest request) throws WxErrorException;

  /**
   * 设置客服信息（即更新客服信息）
   */
  boolean kfAccountUpdate(WxMpKfAccountRequest request) throws WxErrorException;

  /**
   * 设置客服信息（即更新客服信息）
   */
  boolean kfAccountInviteWorker(WxMpKfAccountRequest request) throws WxErrorException;

  /**
   * 上传客服头像
   */
  boolean kfAccountUploadHeadImg(String kfAccount, File imgFile)
          throws WxErrorException;

  /**
   * 删除客服账号
   */
  boolean kfAccountDel(String kfAccount) throws WxErrorException;

  //*******************客服会话控制接口***********************//

  /**
   * 创建会话
   * 此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线。
   */
  boolean kfSessionCreate(String openid, String kfAccount) throws WxErrorException;

  /**
   * 关闭会话
   */
  boolean kfSessionClose(String openid, String kfAccount) throws WxErrorException;

  /**
   * 获取客户的会话状态
   */
  WxMpKfSessionGetResult kfSessionGet(String openid) throws WxErrorException;

  /**
   * 获取客服的会话列表
   */
  WxMpKfSessionList kfSessionList(String kfAccount) throws WxErrorException;

  /**
   * 获取未接入会话列表
   */
  WxMpKfSessionWaitCaseList kfSessionGetWaitCase() throws WxErrorException;

  //*******************获取聊天记录的接口***********************//

  /**
   * 获取聊天记录（原始接口）
   * 此接口返回的聊天记录中，对于图片、语音、视频，分别展示成文本格式的[image]、[voice]、[video]
   *
   * @param startTime 起始时间
   * @param endTime   结束时间
   * @param msgId     消息id顺序从小到大，从1开始
   * @param number    每次获取条数，最多10000条
   * @return 聊天记录对象
   * @throws WxErrorException
   */
  WxMpKfMsgList kfMsgList(Date startTime, Date endTime, Long msgId, Integer number) throws WxErrorException;

  /**
   * 获取聊天记录（优化接口，返回指定时间段内所有的聊天记录）
   * 此接口返回的聊天记录中，对于图片、语音、视频，分别展示成文本格式的[image]、[voice]、[video]
   *
   * @param startTime 起始时间
   * @param endTime   结束时间
   * @return 聊天记录对象
   * @throws WxErrorException
   */
  WxMpKfMsgList kfMsgList(Date startTime, Date endTime) throws WxErrorException;

}
