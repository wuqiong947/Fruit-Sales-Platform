package com.fruitsalesplatform.dao;

import java.util.Map;

import com.fruitsalesplatform.entity.Retailer;

public interface RetailerDao extends BaseDao<Retailer>{
  public int count(Map map) ;
}
