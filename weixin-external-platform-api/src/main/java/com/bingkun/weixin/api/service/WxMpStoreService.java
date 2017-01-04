package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.store.WxMpStoreBaseInfo;
import com.bingkun.weixin.api.dto.store.WxMpStoreInfo;
import com.bingkun.weixin.api.dto.store.WxMpStoreListResult;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/2.
 *
 * 门店管理的相关接口代码
 */
public interface WxMpStoreService {
  /**
   * 创建门店
   */
  void add(WxMpStoreBaseInfo request) throws WxErrorException;

  /**
   * 查询门店信息
   */
  WxMpStoreBaseInfo get(String poiId) throws WxErrorException;

  /**
   * 删除门店
   * 商户可以通过该接口，删除已经成功创建的门店。请商户慎重调用该接口。
   */
  void delete(String poiId) throws WxErrorException;

  /**
   * 查询门店列表(指定查询起始位置和个数)
   * 商户可以通过该接口，批量查询自己名下的门店list，并获取已审核通过的poi_id（所有状态均会返回poi_id，但该poi_id不一定为最终id）、商户自身sid 用于对应、商户名、分店名、地址字段。
   *
   * @param begin 开始位置，0 即为从第一条开始查询
   * @param limit 返回数据条数，最大允许50，默认为20
   * @throws WxErrorException
   */
  WxMpStoreListResult list(int begin, int limit) throws WxErrorException;

  /**
   * 查询门店列表（所有）
   * 商户可以通过该接口，批量查询自己名下的门店list，并获取已审核通过的poi_id（所有状态均会返回poi_id，但该poi_id不一定为最终id）、商户自身sid 用于对应、商户名、分店名、地址字段。
   */
  List<WxMpStoreInfo> listAll() throws WxErrorException;

  /**
   * 修改门店服务信息
   * 商户可以通过该接口，修改门店的服务信息，包括：sid、图片列表、营业时间、推荐、特色服务、简介、人均价格、电话8个字段（名称、坐标、地址等不可修改）修改后需要人工审核。
   *
   */
  void update(WxMpStoreBaseInfo info) throws WxErrorException;

  /**
   * 门店类目表
   */
  List<String> listCategories() throws WxErrorException;

}
