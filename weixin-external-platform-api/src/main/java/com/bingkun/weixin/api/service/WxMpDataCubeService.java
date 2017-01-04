package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.datacube.*;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.util.Date;
import java.util.List;

/**
 * Created by chenxiaobian on 17/1/1.
 * 统计分析相关接口
 */
public interface WxMpDataCubeService {

  //*******************用户分析数据接口*********************//
  /**
   * 获取用户增减数据
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度7天，endDate不能早于begingDate
   */
  List<WxDataCubeUserSummary> getUserSummary(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取累计用户数据
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度7天，endDate不能早于begingDate
   */
  List<WxDataCubeUserCumulate> getUserCumulate(Date beginDate, Date endDate) throws WxErrorException;

  //*******************图文分析数据接口***********************//

  /**
   * 获取图文群发每日数据（getarticlesummary）
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度1天，endDate不能早于begingDate
   */
  List<WxDataCubeArticleResult> getArticleSummary(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取图文群发总数据（getarticletotal）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度1天，endDate不能早于begingDate
   */
  List<WxDataCubeArticleTotal> getArticleTotal(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取图文统计数据（getuserread）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度3天，endDate不能早于begingDate
   */
  List<WxDataCubeArticleResult> getUserRead(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取图文统计分时数据（getuserreadhour）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度1天，endDate不能早于begingDate
   */
  List<WxDataCubeArticleResult> getUserReadHour(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取图文分享转发数据（getusershare）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度7天，endDate不能早于begingDate
   */
  List<WxDataCubeArticleResult> getUserShare(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取图文分享转发分时数据（getusersharehour）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度1天，endDate不能早于begingDate
   */
  List<WxDataCubeArticleResult> getUserShareHour(Date beginDate, Date endDate) throws WxErrorException;

  //*******************消息分析数据接口***********************//

  /**
   * 获取消息发送概况数据（getupstreammsg）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度7天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsg(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取消息分送分时数据（getupstreammsghour）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度1天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsgHour(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取消息发送周数据（getupstreammsgweek）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度30天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsgWeek(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取消息发送月数据（getupstreammsgmonth）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度30天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsgMonth(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取消息发送分布数据（getupstreammsgdist）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度15天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsgDist(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取消息发送分布周数据（getupstreammsgdistweek）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度30天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsgDistWeek(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取消息发送分布月数据（getupstreammsgdistmonth）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度30天，endDate不能早于begingDate
   */
  List<WxDataCubeMsgResult> getUpstreamMsgDistMonth(Date beginDate, Date endDate) throws WxErrorException;

  //*******************接口分析数据接口***********************//
  /**
   * 获取接口分析数据（getinterfacesummary）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度30天，endDate不能早于begingDate
   */
  List<WxDataCubeInterfaceResult> getInterfaceSummary(Date beginDate, Date endDate) throws WxErrorException;

  /**
   * 获取接口分析分时数据（getinterfacesummaryhour）
   *
   * @param beginDate 开始时间
   * @param endDate   最大时间跨度1天，endDate不能早于begingDate
   */
  List<WxDataCubeInterfaceResult> getInterfaceSummaryHour(Date beginDate, Date endDate) throws WxErrorException;

}
