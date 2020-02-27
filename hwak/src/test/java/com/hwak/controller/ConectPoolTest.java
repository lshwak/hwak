package com.hwak.controller;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
// 현재 테스트 코드를 실행할 때 스프링이 로딩되도록 하는 부분
public class ConectPoolTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() throws Exception {
		try (
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = dataSource.getConnection()
			) {
			System.out.println("session = "+session);
			System.out.println("con = "+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
