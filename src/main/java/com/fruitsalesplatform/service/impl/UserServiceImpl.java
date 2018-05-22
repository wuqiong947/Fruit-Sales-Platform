package com.fruitsalesplatform.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.dao.impl.UserDaoImpl;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserDao userDaoImpl;

  @Override
  public User get(Serializable id) {
    // TODO Auto-generated method stub
    return userDaoImpl.get(id);
  }

  @Override
  public List<User> find(Map map) {
    // TODO Auto-generated method stub
    return userDaoImpl.find(map);
  }

  @Override
  public void insert(User user) {
    // TODO Auto-generated method stub
    userDaoImpl.insert(user);
  }

  @Override
  public void update(User user) {
    // TODO Auto-generated method stub
    userDaoImpl.update(user);
  }

  @Override
  public void deleteById(Serializable id) {
    // TODO Auto-generated method stub
    userDaoImpl.deleteById(id);
  }

  @Override
  public void delete(Serializable[] ids) {
    // TODO Auto-generated method stub
    userDaoImpl.delete(ids);
  }
  
}
