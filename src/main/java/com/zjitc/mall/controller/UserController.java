package com.zjitc.mall.controller;

import com.zjitc.mall.common.ServerResponse;
import com.zjitc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 21:43
 * To change this template use File | Setting | File Template.
 * Description : User controller
 * @author kevin
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login.do")
  public ServerResponse login() {
    ServerResponse serverResponse = new ServerResponse();



    return serverResponse;
  }
}
