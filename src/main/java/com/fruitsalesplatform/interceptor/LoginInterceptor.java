package com.fruitsalesplatform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // TODO Auto-generated method stub

    String uri = request.getRequestURI();

    if (!(uri.contains("Login")) || uri.contains("login") || uri.contains("register")) {
      //非登录请求
      if (request.getSession().getAttribute("user")!=null) {
        return true;//说明已经登陆，放行
      }else {
        if (uri.contains("css")||uri.contains("js")||uri.contains("images")) {
          return true;
        }else {
          //没有登陆，跳转到登陆界面
          response.sendRedirect(request.getContextPath()+"/user/toLogin.action");
        }
      }
    }else {
      //登陆请求，直接放行
      return true;
    }
    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

}
