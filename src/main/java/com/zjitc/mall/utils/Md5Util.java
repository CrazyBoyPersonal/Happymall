package com.zjitc.mall.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/8
 * Time : 13:34
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */
public class Md5Util {

  public static String encodeByMD5(String string) {
    byte[] secretBytes = null;
    try {
      secretBytes = MessageDigest.getInstance("md5").digest(
          string.getBytes());
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("找不到md5算法");
    }
    String md5code = new BigInteger(1, secretBytes).toString(16);

    for (int i = 0; i < 32 - md5code.length(); i++) {
      md5code = "0" + md5code;
    }

    return md5code;
  }
}
