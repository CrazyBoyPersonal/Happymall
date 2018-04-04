package com.zjitc.mall.mapper;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 10:46
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */
public interface StatisticMapper {

  /**
   * statistic user count
   *
   * @return
   */
  Integer userCount();

  /**
   * statistic product count
   *
   * @return
   */
  Integer productCount();

  /**
   * statistic order count
   *
   * @return
   */
  Integer orderCount();

}
