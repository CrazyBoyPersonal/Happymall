package com.zjitc.mall.service;

import com.zjitc.mall.common.ServerResponse;
import com.zjitc.mall.mapper.UserMapper;
import com.zjitc.mall.model.User;
import com.zjitc.mall.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.UUID;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/3
 * Time : 21:48
 * To change this template use File | Setting | File Template.
 * Description :
 *
 * @author kevin
 */

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private Jedis jedis;

  @Autowired
  private UserMapper userMapper;

  @Override
  public ServerResponse<User> login(String username, String password) {
    String md5Pwd = Md5Util.encodeByMD5(password);

    User user = userMapper.login(username, md5Pwd);
    if (user == null) {
      return ServerResponse.createError("密码错误");
    }

    return ServerResponse.createSuccess(user);
  }

  @Override
  public ServerResponse<String> register(User user) {
    ServerResponse validResponse = checkValid(user.getUsername(), "username");
    if ((!validResponse.success())) {
      return validResponse;
    }
    validResponse = checkValid(user.getEmail(), "email");
    if (!validResponse.success()) {
      return validResponse;
    }

    user.setRole(0);
    user.setPassword(Md5Util.encodeByMD5(user.getPassword()));
    user.setCreateTime(new Date());
    user.setUpdateTime(new Date());
    Integer resCount = userMapper.register(user);

    if (resCount == 0) {
      return ServerResponse.createError("注册失败");
    }
    return ServerResponse.createSuccess("校验成功");
  }

  @Override
  public ServerResponse checkValid(String str, String type) {
    if ("username".equals(type)) {
      Integer resCountu = userMapper.checkUsername(str);
      if (resCountu > 0) {
        return ServerResponse.createError("用户名已存在");
      }
      if ("email".equals(type)) {
        Integer resCounte = userMapper.checkEamil(str);
        if (resCounte > 0) {
          return ServerResponse.createError("邮箱已被注册");
        }
      }
    }
    return ServerResponse.createSuccess("校验成功");
  }

  @Override
  public ServerResponse selectQuestions(String username) {
    ServerResponse<String> vaildResponse = checkValid(username, "username");
    if (vaildResponse.success()) {
      return ServerResponse.createError("用户名不存在");
    }

    String question = userMapper.selectQuestionByUsername(username);
    return ServerResponse.createSuccess(question);
  }

  @Override
  public ServerResponse checkAnswer(String username, String question, String answer) {
    Integer resCount = userMapper.checkAnswer(username, question, answer);
    if (resCount > 0) {
      String token = UUID.randomUUID().toString();
      jedis.set("token", token);
      jedis.expire("token", 300);
      return ServerResponse.createSuccess(token);
    }

    return ServerResponse.createError("问题答案错误");
  }

  @Override
  public ServerResponse forgetResetPassword(String username, String newPassword, String token) {
    if (token == null) {
      return ServerResponse.createError("需要token");
    }
    ServerResponse response = checkValid(username, "username");
    if (response.success()) {
      return ServerResponse.createError("该用户不存在");
    }
    String reToken = jedis.get("token");

    if (reToken == token) {
      String md5Pwd = Md5Util.encodeByMD5(newPassword);
      Integer resCount = userMapper.updatePassword(username, newPassword, new Date());
      if (resCount > 0) {
        return ServerResponse.createSuccess("修改密码成功");
      }
    } else {
      return ServerResponse.createError("token错误");
    }

    return ServerResponse.createError("修改密码失败");
  }

  @Override
  public ServerResponse resetPassword(String oldPassword, String newPassword, User user) {

    String md5OldPwd = Md5Util.encodeByMD5(oldPassword);
    int id = user.getId();
    Integer resCount = userMapper.checkPassword(md5OldPwd, id);
    if (resCount == 0) {
      return ServerResponse.createError("旧密码错误");
    }
    String md5NewPwd = Md5Util.encodeByMD5(newPassword);
    user.setPassword(md5NewPwd);
    Integer updateCount = userMapper.updatePasswordByUser(md5NewPwd, id);
    if (updateCount > 0) {
      return ServerResponse.createSuccess("密码修改成功");
    }

    return ServerResponse.createError("密码修改失败");
  }

  @Override
  public ServerResponse updateInfomation(User user) {
    String email = user.getEmail();
    Integer id = user.getId();
    Integer resCount = userMapper.checkEamilById(email, id);

    if (resCount > 0) {
      return ServerResponse.createError("email已存在");
    }

    User upUser = new User();
    upUser.setId(user.getId());
    upUser.setEmail(user.getEmail());
    upUser.setPhone(user.getPhone());
    upUser.setQuestion(user.getQuestion());
    upUser.setAnswer(user.getAnswer());
    upUser.setUpdateTime(new Date());

    Integer upCount = userMapper.updateInfomation(upUser);

    if (upCount > 0) {
      return ServerResponse.createSuccess(upUser, "信息更新成功");
    }

    return ServerResponse.createError("信息更新失败");
  }

  @Override
  public ServerResponse getInfomation(Integer id) {
    User user = userMapper.getInfo(id);
    return ServerResponse.createSuccess(user);
  }


}
