/**
 * 
 */
package com.frankstar.javaExam;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author frankstar
 * 数据库链接
 */
public class MySQLConnect {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/JavaStudy?" 
				+ "user=root&password=frankstar&useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载驱动");
			connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			sql = "select * from user";
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("姓名\t住址");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(2) + "\t" +resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
