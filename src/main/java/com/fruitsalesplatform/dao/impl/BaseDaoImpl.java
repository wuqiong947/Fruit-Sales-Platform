package com.fruitsalesplatform.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.fruitsalesplatform.dao.BaseDao;

/**
 * 一个增删改查的基础类抽象实现<br>
 * 
 * extends SqlSessionDaoSupport<br>
 * 
 * implements BaseDao
 * @author 12071
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

  /**
   * 注入在spring中配置的SqlSessionFactory
   */
  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    // TODO Auto-generated method stub
    super.setSqlSessionFactory(sqlSessionFactory);
  }
  
  /**
   * 配置namespace  <br>
   * 因为每个bean都对应一个mapper配置文件，配置namespace来区分
   */
  private String ns;
  
  
  public String getNs() {
    return ns;
  }
  
  public void setNs(String ns) {
    this.ns = ns;
  }

  /**
   * 根据id查询单条数据
   */
  @Override
  public T get(Serializable id) {
    // TODO Auto-generated method stub
    return this.getSqlSession().selectOne(ns+".get",id);
  }

  /**
   * 根据条件查询多条数据
   */
  @Override
  public List<T> find(Map map) {
    // TODO Auto-generated method stub
    return this.getSqlSession().selectList(ns+".find", map);
  }



  /**
   * 根据实例插入单条数据
   */
  @Override
  public void insert(T entity) {
    // TODO Auto-generated method stub
    this.getSqlSession().insert(ns+".insert",entity);
  }

  /**
   * 根据实例更新单条数据
   */
  @Override
  public void update(T entity) {
    // TODO Auto-generated method stub
    this.getSqlSession().update(ns+".update",entity);
  }

  /**
   * 根据id删除单条数据
   */
  @Override
  public void deleteById(Serializable id) {
    // TODO Auto-generated method stub
    this.getSqlSession().delete(ns+".deleteById",id);
  }

  /**
   * 根据ids删除多条数据
   */
  @Override
  public void delete(Serializable[] ids) {
    // TODO Auto-generated method stub
    this.getSqlSession().delete(ns+".delect",ids);
  }


  
}
