package com.frankstar.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.frankstar.mybatis.inter.IUserOperation;
import com.frankstar.mybatis.model.Article;
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
	public void addUser() {
		User user = new User();
		user.setUserAddress("南大仙林小区四组团");
		user.setUserAge(25);
		user.setUserName("小叶叶");
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			session.commit();
			System.out.println("当前增加的用户ID为：" + user.getId());
		} finally {
			session.close();
		}
	}
	public void updateUser() {
		//先得到用户，然后修改提交
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(2);
			user.setUserAddress("513宿舍");
			user.setUserAge(24);
			user.setUserName("叶红星");
			userOperation.updateUser(user);
			session.commit();
		} finally {
			session.close();
		}
		
	}
	public void deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void getUserArticles(int userid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<Article> articles = userOperation.getUserArticles(userid);
			for(Article article : articles) {
				System.out.println(article.getTitle() + ":" + article.getContent() + ":" +
						"作者是：" + article.getUser().getUserName() + "地址是：" + article.getUser().getUserAddress());
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
//		users.addUser();
//		users.updateUser();
//		users.deleteUser(5);
		users.getUserArticles(1);
	}

}
