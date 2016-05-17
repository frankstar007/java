/**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author frankstar
 * 获取数据库自动生成的主键
 */
public class KeyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into keyTest (name) values('frankstar')";
			pStatement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			pStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			//获取主键
			resultSet = pStatement.getGeneratedKeys();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}

}
