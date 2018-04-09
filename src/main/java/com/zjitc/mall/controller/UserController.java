package com.zjitc.mall.controller;

import com.zjitc.mall.common.ServerResponse;
import com.zjitc.mall.model.User;
import com.zjitc.mall.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 21:43
 * To change this template use File | Setting | File Template.
 * Description : User controller
 *
 * @author kevin
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * user login
   *
   * @param username
   * @param password
   * @param session
   * @return
   */
  @RequestMapping(value = "/login.do", method = RequestMethod.POST)
  @ResponseBody
  public ServerResponse login(
      @RequestParam(value = "username") String username,
      @RequestParam(value = "password") String password,
      HttpSession session) {

    ServerResponse<User> serverResponse = userService.login(username, password);
    if (serverResponse.success()) {
      session.setAttribute("user", serverResponse.getData());
    }
    return serverResponse;
  }


  /**
   * user register
   *
   * @param username
   * @param password
   * @param email
   * @param phone
   * @param question
   * @param answer
   * @return
   */
  @RequestMapping(value = "/register.do", method = RequestMethod.POST, headers = "Accept=application/json")
  @ResponseBody
  public ServerResponse<String> register(
      @RequestParam(value = "username") String username,
      @RequestParam(value = "password") String password,
      @RequestParam(value = "email") String email,
      @RequestParam(value = "phone") String phone,
      @RequestParam(value = "question") String question,
      @RequestParam(value = "answer") String answer) {

    User user = new User(null, username, password, email, phone, question, answer, null, null, null);

    ServerResponse<String> serverResponse = userService.register(user);

    return serverResponse;
  }

  /**
   * check valid
   *
   * @param str
   * @param type
   * @return
   */
  @RequestMapping(value = "check_valid.do", method = RequestMethod.POST, headers = "Accept=application/json")
  public ServerResponse checkValid(
      @RequestParam(value = "str") String str,
      @RequestParam(value = "type") String type) {

    return userService.checkValid(str, type);
  }

  @RequestMapping(value = "/get_user_info.do", method = RequestMethod.POST, headers = "Accept=application/json")
  @ResponseBody
  public ServerResponse getUserInfo(HttpSession session) {
    User user = (User) session.getAttribute("user");
    if (user == null) {
      return ServerResponse.createSuccess(user);
    }
    return ServerResponse.createError("用户未登录,无法获取当前用户信息");
  }

  /**
   * forget get question
   *
   * @param username
   * @return
   */
  @RequestMapping(value = "/forget_get_question.do", method = RequestMethod.POST, headers = "Accrept=application/json")
  @ResponseBody
  public ServerResponse forgetGetQuestion(@RequestParam(value = "username") String username) {
    return userService.selectQuestions(username);
  }

  /**
   * forget check answer
   *
   * @param username
   * @param question
   * @param answer
   * @return
   */
  @RequestMapping(value = "/forget_check_answer.do", method = RequestMethod.POST, headers = "Accrept=application/json")
  @ResponseBody
  public ServerResponse forgetCheckAnswer(
      @RequestParam(value = "username") String username,
      @RequestParam(value = "question") String question,
      @RequestParam(value = "answer") String answer) {

    ServerResponse response = userService.checkAnswer(username, question, answer);
    return response;
  }

  /**
   * forget reset password
   *
   * @param username
   * @param newPassword
   * @param token
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/forget_reset_password.do", method = RequestMethod.GET, headers = "Accrept=application/json")
  public ServerResponse forgeResetPassword(
      @RequestParam(value = "username") String username,
      @RequestParam(value = "newPassword") String newPassword,
      @RequestParam(value = "token") String token) {

    ServerResponse response = userService.forgetResetPassword(username, newPassword, token);
    return response;
  }

  /**
   * reset password
   *
   * @param newPassword
   * @param oldPassword
   * @param session
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/reset_password.do", method = RequestMethod.GET, headers = "Accrept=application/json")
  public ServerResponse resetPassword(
      @RequestParam(value = "newPassword") String newPassword,
      @RequestParam(value = "oldPassword") String oldPassword,
      HttpSession session) {

    User user = (User) session.getAttribute("user");
    if (user == null) {
      return ServerResponse.createError("用户未登录");
    }

    ServerResponse response = userService.resetPassword(oldPassword, newPassword, user);
    return response;
  }

  /**
   * updata infomation
   *
   * @param email
   * @param phone
   * @param question
   * @param answer
   * @param session
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/update_information.do", method = RequestMethod.GET, headers = "Accrept=application/json")
  public ServerResponse updateInfomation(
      @RequestParam(value = "email") String email,
      @RequestParam(value = "phone") String phone,
      @RequestParam(value = "question") String question,
      @RequestParam(value = "answer") String answer,
      HttpSession session) {

    User user = (User) session.getAttribute("user");
    if (user == null) {
      return ServerResponse.createError("用户未登录");
    }

    user.setId(user.getId());
    user.setUsername(user.getUsername());
    ServerResponse response = userService.updateInfomation(user);

    if (response.success()) {
      session.setAttribute("user", response.getData());
    }
    return response;
  }

  /**
   * get infomation
   *
   * @param session
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/get_information.do", method = RequestMethod.GET, headers = "Accrept=application/json")
  public ServerResponse getInfomation(HttpSession session) {

    User user = (User) session.getAttribute("user");
    if (user == null) {
      return ServerResponse.createError("用户未登录");
    }

    ServerResponse response = userService.getInfomation(user.getId());

    return response;
  }

  /**
   * user logout
   *
   * @param session
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/logout.do", method = RequestMethod.GET, headers = "Accrept=application/json")
  public ServerResponse logout(HttpSession session) {
    session.removeAttribute("user");
    return ServerResponse.createSuccess("退出成功");
  }

}
