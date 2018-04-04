package com.zjitc.mall.utils.redisutils;

import redis.clients.jedis.Jedis;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/4
 * Time : 11:41
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */
public class RedisImpl  implements Redis{

  @Override
  public void set(String key, String value) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    jedis.set(key, value);
  }

  @Override
  public String get(String key) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    return jedis.get(key);
  }

  @Override
  public Boolean isExist(String key) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    return jedis.exists(key);
  }

  @Override
  public void del(String key) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    jedis.del(key);
  }

  @Override
  public void ecpire(String key, Integer second) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    jedis.expire(key, second);
  }

  @Override
  public void expireat(String key, Long timestamp) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    jedis.expireAt(key, timestamp);
  }

  @Override
  public void pexpire(String key, Long millisecond) {
    InitRedis redis = InitRedis.crateFactory();
    Jedis jedis = redis.connection();
    jedis.pexpire(key, millisecond);
  }
}
