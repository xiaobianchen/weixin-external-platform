package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.menu.WxMpGetSelfMenuInfoResult;
import com.bingkun.weixin.common.dto.menu.WxMenu;
import com.bingkun.weixin.common.exception.WxErrorException;

/**
 * Created by chenxiaobian on 2017/1/2.
 * 菜单相关操作接口
 */
public interface WxMpMenuService {

  /**
   * 自定义菜单创建接口
   */
  void menuCreate(WxMenu menu) throws WxErrorException;

  /**
   * 自定义菜单删除接口
   */
  void menuDelete() throws WxErrorException;

  /**
   * 删除个性化菜单接口
   *
   * @param menuid
   */
  void menuDelete(String menuid) throws WxErrorException;

  /**
   * 自定义菜单查询接口
   */
  WxMenu menuGet() throws WxErrorException;

  /**
   * 测试个性化菜单匹配结果
   *
   * @param userid 可以是粉丝的OpenID，也可以是粉丝的微信号。
   */
  WxMenu menuTryMatch(String userid) throws WxErrorException;

  /**
   * 获取自定义菜单配置接口
   */
  WxMpGetSelfMenuInfoResult getSelfMenuInfo() throws WxErrorException;
}
