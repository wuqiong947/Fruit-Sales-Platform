package com.fruitsalesplatform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.entity.User;

public interface RetailerService {

  //查询单条数据
  public Retailer get(Serializable id) ;
  //根据条件查询多条数据
  public List<Retailer> find(Map map) ;
  //插入，参数为实体类
  public void insert(Retailer retailer) ;
  //更新，参数为实体类
  public void update(Retailer retailer) ;
  //单件删除
  public void deleteById(Serializable id) ;
  //多件删除
  public void delete(Serializable[] ids) ;
  //查询根据条件统计数量
  public int count(Map map) ;
}
