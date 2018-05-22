package com.fruitsalesplatform.test.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fruitsalesplatform.test.entity.User;

public class DBConnectionTest {
	
	private String resource = "beans.xml";

	private SqlSessionFactory sqlSessionFactory;

	private SqlSession sqlSession = null;

	public SqlSession getSqlSession() throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
		sqlSessionFactory = (SqlSessionFactory) context.getBean("sessionFactory");
		
		sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	@Test
	public void testSelect() throws Exception{
		sqlSession = getSqlSession();
		User user = sqlSession.selectOne("test.findUserByName","吴国琼");
		
		System.out.println("查询结果");
		System.out.println("电话"+user.getTelephone());
	}
}
