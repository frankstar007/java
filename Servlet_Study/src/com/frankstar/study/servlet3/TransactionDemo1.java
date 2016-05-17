/**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.coyote.http11.filters.VoidInputFilter;

/**
 * @author frankstar
 * 使用事物模拟转账
 */
public class TransactionDemo1 {

	@SuppressWarnings("resource")
	public void testTransaction() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtils.getConnection();
			//通知数据库开启事物
			connection.setAutoCommit(false);
			String sql1 = "update account set money=money-100 where name='A'";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();
			String sql2 = "update account set money=money+100 where name='b'";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
			connection.commit();
			System.out.println("执行完毕！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
		
	}
	
	public void testRollBack() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);
			String sql1 = "update account set money=money-100 where name='A'";
			pStatement = connection.prepareStatement(sql1);
			pStatement.executeUpdate();
			
			int x = 1/0;
			String sql2 = "update account set money=money+100 where name='b'";
			pStatement = connection.prepareStatement(sql2);
			pStatement.executeUpdate();
			connection.commit();
			
			System.out.println("成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
	public void testRollBackByHand() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);
			String sql1 = "update account set money=money-100 where name='A'";
			pStatement = connection.prepareStatement(sql1);
			pStatement.executeUpdate();
			
			int x = 1/0;
			String sql2 = "update account set money=money+100 where name='b'";
			pStatement = connection.prepareStatement(sql2);
			pStatement.executeUpdate();
			connection.commit();
			
			System.out.println("成功！");
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
	//设置回滚点
	@SuppressWarnings("resource")
	public void testRollbackPoint() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Savepoint point = null;
		
		try {
			connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);
			String sql1 = "update account set money=money-100 where name='A'";
			pStatement = connection.prepareStatement(sql1);
			pStatement.executeUpdate();
			
			//设置回滚点
			point = connection.setSavepoint();
			
			String sql2 = "update account set money=money+100 where name='b'";
			pStatement = connection.prepareStatement(sql2);
			pStatement.executeUpdate();
			
			int x = 1/0;
			String sql3 = "update account set money=money+100 where name='c'";
			pStatement = connection.prepareStatement(sql3);
			pStatement.executeUpdate();
			connection.commit();
			System.out.println("成功！");
		} catch (Exception e) {
			try {
				connection.rollback(point);
				connection.commit();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransactionDemo1 test = new TransactionDemo1();
		//test.testTransaction();
		//test.testRollBack();
		//test.testRollBackByHand();
		test.testRollbackPoint();
		
	}

}
