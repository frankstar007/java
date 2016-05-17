package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSecondDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/JavaStudy";
		String username = "root";
		String password = "frankstar";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		//String sql = "insert into user (userName,userAge,userAddress) values (\"yeye\",24,\"南京\")";
		//String sql = "update user set userName =\"星星\" where id=7";
		String sql = "delete from user where id = 8";
		int num = statement.executeUpdate(sql);
		if (num > 0) {
			System.out.println("成功！");
		}
		statement.close();
		connection.close();

		
		
	}

}
