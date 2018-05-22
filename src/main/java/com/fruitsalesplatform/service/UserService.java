package com.fruitsalesplatform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fruitsalesplatform.entity.User;

public interface UserService {
  //查询单条数据
  public User get(Serializable id) ;
  //根据条件查询多条数据
  public List<User> find(Map map) ;
  //插入，参数为实体类
  public void insert(User user) ;
  //更新，参数为实体类
  public void update(User user) ;
  //单件删除
  public void deleteById(Serializable id) ;
  //多件删除
  public void delete(Serializable[] ids) ;
}
