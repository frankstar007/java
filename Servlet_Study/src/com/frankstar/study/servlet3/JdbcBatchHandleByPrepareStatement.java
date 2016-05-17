/**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * @author frankstar
 * 使用prepareStatement实现JDBC批处理操作
 */
public class JdbcBatchHandleByPrepareStatement {
	public void testJdbcBatchHandleByPrepareStatement() {
		long starttime = System.currentTimeMillis();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into batch (id,name) values (?,?)";
			pStatement = connection.prepareStatement(sql);
			for (int i = 0; i < 1000008; i++) {
				pStatement.setInt(1, i);
				pStatement.setString(2, "aa" + i);
				pStatement.addBatch();
				if (i % 1000 == 0) {
					pStatement.executeBatch();
					pStatement.clearBatch();
				}
			}
			pStatement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("程序消费时间：" + (endtime - starttime));
	}
	
	public static void main(String[] args) {
		JdbcBatchHandleByPrepareStatement teStatement = new JdbcBatchHandleByPrepareStatement();
		teStatement.testJdbcBatchHandleByPrepareStatement();
	}
}
