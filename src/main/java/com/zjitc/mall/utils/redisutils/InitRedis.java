package com.zjitc.mall.utils.redisutils;

import redis.clients.jedis.Jedis;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/4
 * Time : 12:26
 * To change this template use File | Setting | File Template.
 * Description : connection redis and init jedis
 * @author kevin
 */
public class InitRedis {

  private static final String ip = "127.0.0.1";
  private static final Integer port = 6379;

  public Jedis connection() {
    Jedis jedis = new Jedis(ip, port);
    return jedis;
  }

  public static InitRedis crateFactory() {
    return new InitRedis();
  }
}
