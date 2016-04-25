package com.frankstar.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.frankstar.mybatis.inter.IUserOperation;
import com.frankstar.mybatis.model.User;
import java.util.List;

public class Demo2 {
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
	public void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsers(userName);
			for(User user:users) {
				System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAge());
			}
		} finally {
			session.close();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(1);
			System.out.println(user.getUserName());
			System.out.println(user.getUserAddress());
		} finally {
			session.close();
		}
		Demo2 users = new Demo2();
		users.getUserList("%");
	}

}
