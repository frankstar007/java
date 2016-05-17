 /**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author frankstar
 * 使用statement实现jdbc批处理操作
 * 缺点sql语句没有预编译
 */
public class JdbcBatchHandleByStatement {
	public void testJdbcBatchHandleByStatement() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql1 = "insert into batch (id,name) values(1,'aaa')";
			String sql2 = "insert into batch (id,name) values(2,'bbb')";
			String sql3 = "insert into batch (id,name) values(3,'ccc')";
			String sql4 = "insert into batch (id,name) values(4,'ddd')";
			String sql5 = "update batch set name='frankstar' where id=1";
			String sql6 = "insert into batch (id,name) values(5,'eee')";
			String sql7 = "delete from batch where id=2";
			
			statement = connection.createStatement();
			//添加要执行的sql
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			statement.addBatch(sql4);
			statement.addBatch(sql5);
			statement.addBatch(sql6);
			statement.addBatch(sql7);
			
			statement.executeBatch();
			statement.clearBatch();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, statement, resultSet);
		}
	}
	public static void main(String[] args) {
		JdbcBatchHandleByStatement teStatement = new JdbcBatchHandleByStatement();
		teStatement.testJdbcBatchHandleByStatement();
	}
}
