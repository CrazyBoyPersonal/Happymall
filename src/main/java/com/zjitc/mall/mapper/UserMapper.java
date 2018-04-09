package com.zjitc.mall.mapper;

import com.zjitc.mall.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/8
 * Time : 12:51
 * To change this template use File | Setting | File Template.
 * Description :
 *
 * @author kevin
 */
public interface UserMapper {

  /**
   * user login
   *
   * @param username
   * @param md5Pwd
   * @return
   */
  User login(
      @Param("username") String username,
      @Param("md5Pwd") String md5Pwd);

  /**
   * check username
   *
   * @param str
   * @return
   */
  Integer checkUsername(@Param("str") String str);

  /**
   * check email
   *
   * @param str
   * @return
   */
  Integer checkEamil(@Param("str") String str);

  /**
   * user login
   *
   * @param user
   * @return
   */
  Integer register(User user);

  /**
   * forget get question
   *
   * @param username
   * @return
   */
  String selectQuestionByUsername(@Param("username") String username);

  /**
   * check answer
   *
   * @param username
   * @param question
   * @param answer
   * @return
   */
  Integer checkAnswer(
      @Param("username") String username,
      @Param("question") String question,
      @Param("answer") String answer);

  /**
   * reset password
   *
   * @param username
   * @param newPassword
   * @param date
   * @return
   */
  Integer updatePassword(
      @Param("username") String username,
      @Param("newPassword") String newPassword,
      Date date);


  /**
   * check password
   *
   * @param md5OldPwd
   * @param id
   * @return
   */
  Integer checkPassword(@Param("md5OldPwd") String md5OldPwd, @Param("id") Integer id);

  /**
   * update password
   *
   * @param md5NewPwd
   * @param id
   * @return
   */
  Integer updatePasswordByUser(@Param("md5NewPwd") String md5NewPwd, @Param("id") Integer id);

  /**
   * check email by id
   *
   * @param email
   * @param id
   * @return
   */
  Integer checkEamilById(@Param("email") String email, @Param("id") Integer id);

  /**
   * update info
   *
   * @param upUser
   * @return
   */
  Integer updateInfomation(User upUser);

  /**
   * get user info
   *
   * @param id
   * @return
   */
  User getInfo(@Param("id") Integer id);
}
