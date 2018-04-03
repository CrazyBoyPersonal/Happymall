package com.zjitc.mall.service;

import com.zjitc.mall.mapper.StatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 10:26
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */

@Service
public class StatisticServiceImpl implements  StatisticService {

  @Autowired
  private StatisticMapper statisticMapper;

  @Override
  public Map<String, Integer> statisticCount() {
    Map<String, Integer> reqMap = new HashMap<String, Integer>();

    Integer userCount = statisticMapper.userCount();
    Integer productCount = statisticMapper.productCount();
    Integer orderCount = statisticMapper.orderCount();

    reqMap.put("userCount", userCount);
    reqMap.put("productCount", productCount);
    reqMap.put("orderCount", orderCount);

    return reqMap;
  }
}
