package com.fruitsalesplatform.dao.impl;

import org.testng.annotations.Test;
import org.springframework.stereotype.Repository;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
  public UserDaoImpl() {
    // TODO Auto-generated constructor stub
    super.setNs("com.fruitsalesplatform.mapper.UserMapper");
  } 
  

}
