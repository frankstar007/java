/**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author frankstar
 * 测试数据库连接池
 */
public class JdbcUtil {

	private static JdbcPool pool = new JdbcPool();
	public static Connection getConnection() throws SQLException {
		return pool.getConnection();
	}
	
	public static void release(Connection connection,Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultSet = null;
		
		}
		
		if (statement != null) {
			try {
				statement.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//JdbcUtil pool = new JdbcUtil();
		JdbcUtil.getConnection();
	}

}
