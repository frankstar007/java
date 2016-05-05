package com.frankstar.javaExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String url = " jdbc:mysql://localhost:3306/JavaStudy?characterEncoding=utf-8,root, frankstar";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from user");
		if (resultSet.next()) {
			System.out.println(resultSet.getString("userName"));
		}
		connection.close();
		
	}

}
