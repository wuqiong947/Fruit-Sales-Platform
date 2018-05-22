package com.fruitsalesplatform.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;

@Controller
public class UserController extends BaseController{
  
  @Resource
  UserService userService;
  
  
  @RequestMapping("/user/toLogin.action")
  public String toLogin() {
    //转向登陆界面
    return "/login.jsp";
  }
  
  @RequestMapping("/user/login.action")
  public String login(User user,Model model,HttpServletRequest request){
    
    Map<String, String> map = new HashMap<String, String>();
    
    map.put("username", user.getUsername());
    map.put("password", user.getPassword());
    
    List<User> userList =  userService.find(map);
    
    //如果查询出结果证明账号密码正确，可以往session中注入user然后跳转页面
    if (userList != null && userList.size()>0) {
      
      model.addAttribute("user", userList.get(0));
      
      return "/home.jsp";
    }
    
    //输入错误未能查询到结果，返回login界面并带回错误信息
    model.addAttribute("errorMsg","登陆失败！账号或密码错误");
    
    return "/login.jsp";
  }
  
  
  
  @RequestMapping("/user/register.action")
  public String register(User user,Model model){
    
    Map<String, String> map = new HashMap<String, String>();
    
    map.put("username", user.getUsername());
    
    List<User> userList = userService.find(map);
    
    if (userList !=null && userList.size()>0) {
      model.addAttribute("errorMsg","注册用户已存在，请重新输入");
      return "/register.jsp";
    }
    user.setUserid(UUID.randomUUID().toString());
    
    userService.insert(user);
    
    model.addAttribute("noticeMsg","注册成功!请输入账号密码登陆");
    
    return "/login.jsp";
  }
  
  @RequestMapping("/user/registerPage.action")
  public String toRegister(){
    return "/register.jsp";
  }
  
}
