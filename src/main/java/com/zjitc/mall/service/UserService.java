package com.zjitc.mall.service;

import com.zjitc.mall.common.ServerResponse;
import com.zjitc.mall.model.User;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 21:48
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */
public interface UserService {


  /**
   * user login
   * @param username
   * @param password
   * @return
   */
  ServerResponse<User> login(String username, String password);

  /**
   * user register
   * @param user
   * @return
   */
  ServerResponse<String> register(User user);

  /**
   * check valid
   * @param str
   * @param type
   * @return
   */
  ServerResponse checkValid(String str, String type);

  /**
   * forget get question
   * @param username
   * @return
   */
  ServerResponse selectQuestions(String username);

  /**
   * check answer
   * @param username
   * @param question
   * @param answer
   * @return
   */
  ServerResponse checkAnswer(String username, String question, String answer);

  /**
   * reset password
   * @param username
   * @param newPassword
   * @param token
   * @return
   */
  ServerResponse forgetResetPassword(String username, String newPassword, String token);

  /**
   * reset password
   * @param oldPassword
   * @param newPassword
   * @param user
   * @return
   */
  ServerResponse resetPassword(String oldPassword, String newPassword, User user);

  /**
   * update infomation
   * @param user
   * @return
   */
  ServerResponse updateInfomation(User user);

  /**
   * get info
   * @param id
   * @return
   */
  ServerResponse getInfomation(Integer id);
}
