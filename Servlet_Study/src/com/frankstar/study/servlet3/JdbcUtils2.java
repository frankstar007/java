/**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource;

/**
 * @author frankstar
 * 数据库连接类 使用ThreadLocal
 */
public class JdbcUtils2 {
	private static ComboPooledDataSource ds = null;
	//使用ThreadLocal存储当前线程池中的Connection对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	//静态代码块中创建数据库连接池
	static {
		try {
			ds = new ComboPooledDataSource("MySQL");
		} catch (Exception e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws SQLException {
		//从当前线程中取出连接
		Connection connection = threadLocal.get();
		if (connection == null) {
			//数据源中获取数据库中的连接
			connection = getDataSource().getConnection();
			threadLocal.set(connection);
		}
		
		return connection;
	}
	//开启事务
	public static void startTransaction() {
		try {
			Connection connection = threadLocal.get();
			if (connection == null) {
				connection = getConnection();
				threadLocal.set(connection);
			}
			//开启事务
			connection.setAutoCommit(false);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	//回滚事务
	public static void rollback() {
		try {
			Connection connection = threadLocal.get();
			if (connection != null) {
				connection.rollback();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	//提交事务
	public static void commit() {
		try {
			Connection connection = threadLocal.get();
			if (connection != null) {
				connection.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public static void close() {
		try {
			Connection connection = threadLocal.get();
			if (connection != null) {
				connection.close();
				threadLocal.remove();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static DataSource getDataSource() {
		// TODO Auto-generated method stub
		return ds;
	}

}
