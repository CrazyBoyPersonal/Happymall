package com.zjitc.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 21:48
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private Jedis jedis;

  public void check(String username) {
    jedis.sadd("username", username);
  }
}
