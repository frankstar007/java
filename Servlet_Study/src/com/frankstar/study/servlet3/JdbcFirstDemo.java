package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//链接数据的URL
		String url = "jdbc:mysql://localhost:3306/JavaStudy";
		//使用的用户名
		String username = "root";
		//密码
		String password = "frankstar";
		
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取与数据库的链接
		Connection connection = DriverManager.getConnection(url, username, password);
		//获取用于向数据库发送sql语句 的statement
		Statement statement = connection.createStatement();
		//定义sql
		String sql = "select * from user";
		//像数据库发sql,获取结果集
		ResultSet resultSet = statement.executeQuery(sql);
		//取出结果集
		System.out.println("id" + "\t" + "name" + "\t" + "age" + "\t" + "address");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString("username")
			+ "\t" + resultSet.getObject("userage") + "\t" + resultSet.getString(4));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
