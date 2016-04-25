/**
 * 
 */
package com.frankstar.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.frankstar.mybatis.model.User;

/**
 * @author frankstar
 * @function 测试mybatis的demo
 */
public class Demo1 {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static{
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = (User) session.selectOne("com.frankstar.mybatis.models.UserMapper.selectUserByID", 2);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}

}
