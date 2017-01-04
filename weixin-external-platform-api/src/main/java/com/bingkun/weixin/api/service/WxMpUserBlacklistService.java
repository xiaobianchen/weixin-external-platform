package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.result.WxMpUserBlacklistGetResult;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/2.
 *
 * 用户黑名单
 */
public interface WxMpUserBlacklistService {
  /**
   * 获取公众号的黑名单列表
   */
  WxMpUserBlacklistGetResult getBlacklist(String nextOpenid) throws WxErrorException;

  /**
   *  拉黑用户
   */
  void pushToBlacklist(List<String> openidList) throws WxErrorException;

  /**
   *  取消拉黑用户
   */
  void pullFromBlacklist(List<String> openidList) throws WxErrorException;
}
