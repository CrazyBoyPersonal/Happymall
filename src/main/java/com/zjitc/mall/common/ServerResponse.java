package com.zjitc.mall.common;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 09:53
 * To change this template use File | Setting | File Template.
 * Description :
 *
 * @author kevin
 */
public class ServerResponse<T> {
  private Integer status;
  private String msg;
  private T data;

  public ServerResponse(Integer status) {
    this.status = status;
  }

  public ServerResponse(Integer status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public ServerResponse(Integer status, T data) {
    this.status = status;
    this.data = data;
  }

  public ServerResponse(Integer status, String msg, T data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public Integer getStatus() {
    return status;
  }

  public String getMsg() {
    return msg;
  }

  public T getData() {
    return data;
  }

  public boolean success() {
    return this.status.equals(ServerResponseCode.SUCCESS);
  }

  public static <T> ServerResponse createSuccess(String msg) {
    return new ServerResponse(ServerResponseCode.SUCCESS, msg);
  }

  public static <T> ServerResponse createSuccess(T data) {
    return new ServerResponse(ServerResponseCode.SUCCESS, data);
  }

  public static <T> ServerResponse createSuccess(T data, String msg) {
    return new ServerResponse(ServerResponseCode.SUCCESS, msg, data);
  }

  public static <T> ServerResponse createError(String msg) {
    return new ServerResponse(ServerResponseCode.ERROR, msg);
  }

  public static <T> ServerResponse createError(T data) {
    return new ServerResponse(ServerResponseCode.ERROR, data);
  }

  public static <T> ServerResponse createError(T data, String msg) {
    return new ServerResponse(ServerResponseCode.ERROR, msg, data);
  }


}
