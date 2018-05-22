package com.fruitsalesplatform.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitsalesplatform.test.dao.TestDao;
import com.fruitsalesplatform.test.entity.User;
import com.fruitsalesplatform.test.service.TestService;
import com.sun.mail.handlers.text_html;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  private TestDao testDao;

  @Override
  public List<User> findUserByName(User user) {
    // TODO Auto-generated method stub

    List<User> userList = testDao.findUserByName(user);

    return userList;
  }

}
