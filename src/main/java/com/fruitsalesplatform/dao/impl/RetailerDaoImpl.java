package com.fruitsalesplatform.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;

@Repository
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao{

  public RetailerDaoImpl() {
    // TODO Auto-generated constructor stub
    super.setNs("com.fruitsalesplatform.mapper.RetailerMapper");
  } 
  
  
  @Override
  public int count(Map map) {
    // TODO Auto-generated method stub
    return this.getSqlSession().selectOne(this.getNs()+".count",map);
  }

}
