package com.zjitc.mall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjitc.mall.common.ServerResponse;
import com.zjitc.mall.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static com.zjitc.mall.common.ServerResponseCode.SUCCESS;


/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/2
 * Time : 19:28
 * To change this template use File | Setting | File Template.
 * Description : 统计： 统计用户、商品、订单数量
 *
 * @author kevin
 */

@Controller
@RequestMapping(value = "/manage/statistic")
public class StatisticController {

  @Autowired
  private StatisticService statisticService;

  @ResponseBody
  @RequestMapping(value = "/base_count.do", method = RequestMethod.GET, headers = "Accept=application/json")
  public ServerResponse baseCount() throws JsonProcessingException {
    Map<String, Object> reqMap = statisticService.statisticCount();

    return new ServerResponse(SUCCESS, reqMap);
  }
}
