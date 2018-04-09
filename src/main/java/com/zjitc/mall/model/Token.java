package com.zjitc.mall.model;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/8
 * Time : 14:13
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */
public class Token {
  private String uuid;

  public Token() {
  }

  public Token(String uuid) {
    this.uuid = uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  @Override
  public String toString() {
    return "Token{" +
        "uuid='" + uuid + '\'' +
        '}';
  }
}
