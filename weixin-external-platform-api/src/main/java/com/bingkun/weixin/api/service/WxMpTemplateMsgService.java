package com.bingkun.weixin.api.service;

import com.bingkun.weixin.api.dto.template.WxMpTemplate;
import com.bingkun.weixin.api.dto.template.WxMpTemplateIndustry;
import com.bingkun.weixin.api.dto.template.WxMpTemplateMessage;
import com.bingkun.weixin.common.exception.WxErrorException;

import java.util.List;

/**
 * Created by chenxiaobian on 2017/1/2.
 *
 * 模板消息接口
 */
public interface WxMpTemplateMsgService {

  /**
   * 设置所属行业
   * @return 是否成功
   */
  boolean setIndustry(WxMpTemplateIndustry wxMpIndustry) throws WxErrorException;

  /***
   * 获取设置的行业信息
   * @return wxMpIndustry
   */
  WxMpTemplateIndustry getIndustry() throws WxErrorException;

  /**
   * 发送模板消息
   *
   * @return 消息Id
   */
  String sendTemplateMsg(WxMpTemplateMessage templateMessage) throws WxErrorException;

  /**
   * 获得模板ID
   * 从行业模板库选择模板到帐号后台，获得模板ID的过程可在MP中完成
   *
   * @param shortTemplateId 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
   * @return templateId 模板Id
   */
  String addTemplate(String shortTemplateId) throws WxErrorException;

  /**
   * 获取模板列表
   * 获取已添加至帐号下所有模板列表，可在MP中查看模板列表信息，为方便第三方开发者，提供通过接口调用的方式来获取帐号下所有模板信息
   *
   * @return templateId 模板Id
   */
  List<WxMpTemplate> getAllPrivateTemplate() throws WxErrorException;

  /**
   * 删除模板
   * 删除模板可在MP中完成，为方便第三方开发者，提供通过接口调用的方式来删除某帐号下的模板
   *
   * @param templateId 模板Id
   */
  boolean delPrivateTemplate(String templateId) throws WxErrorException;
}
