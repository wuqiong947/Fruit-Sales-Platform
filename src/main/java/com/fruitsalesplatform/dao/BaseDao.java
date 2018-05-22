package com.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
  //查询单条数据
  public T get(Serializable id) ;
  //根据条件查询多条数据
  public List<T> find(Map map) ;
  //插入，参数为实体类
  public void insert(T entity) ;
  //更新，参数为实体类
  public void update(T entity) ;
  //单件删除
  public void deleteById(Serializable id) ;
  //多件删除
  public void delete(Serializable[] ids) ;
}
