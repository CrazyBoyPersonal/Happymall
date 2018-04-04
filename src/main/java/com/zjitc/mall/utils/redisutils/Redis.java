package com.zjitc.mall.utils.redisutils;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/4
 * Time : 11:30
 * To change this template use File | Setting | File Template.
 * Description : java redis interface
 * @author kevin
 */
public interface Redis {

  /**
   * add key value
   * @param key
   * @param value
   */
  void set(String key, String value);

  /**
   * get value by key
   * @param key
   * @return value
   */
  String get(String key);

  /**
   * is exist this key?
   * @param key
   * @return
   */
  Boolean isExist(String key);

  /**
   * delete
   * @param key
   */
  void del(String key);

  /**
   * Set the expiration time
   * the unit is second
   * @param key
   * @param second
   */
  void ecpire(String key, Integer second);

  /**
   * Set the expiration time
   * the unit is timestamp
   * @param key
   * @param timestamp
   */
  void expireat(String key, Long timestamp);

  /**
   * Set the expiration time
   * the unit is millisecond
   * @param key
   * @param millisecond
   */
  void pexpire(String key, Long millisecond);
}
