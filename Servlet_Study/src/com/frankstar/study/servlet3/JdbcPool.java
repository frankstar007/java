/**
 * 
 */
package com.frankstar.study.servlet3;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * @author frankstar
 * 编写数据库链接池
 */
public class JdbcPool implements DataSource{
	private static LinkedList<Connection> listConnections = new LinkedList<Connection>();
	
	static{
		InputStream inputStream = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(inputStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			//数据库连接数的大小
			int poolSize = Integer.parseInt(properties.getProperty("poolsize"));
			Class.forName(driver);
			
			for (int i = 0; i < poolSize; i++) {
				Connection connection = DriverManager.getConnection(url, username, password);
				System.out.println("获取链接：" + connection);
				listConnections.add(connection);
			}
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		//如果数据库连接池的连接对象的个数大于0
		if (listConnections.size() > 0) {
			//取出一个数据库连接
			final Connection connection = listConnections.removeFirst();
			System.out.println("数据库连接池大小是：" + listConnections.size());
			return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), connection.getClass().getInterfaces(),
					new InvocationHandler() {
						
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							// TODO Auto-generated method stubif 
							if (!method.getName().equals("close")) {
								return method.invoke(connection, args);
							} else {
								listConnections.add(connection);
								System.out.println(connection + "返回连接池！");
								System.out.println("连接池大小为：" + listConnections.size());
								return null;
							}
						}
					});
		} else {
			throw new RuntimeException("对不起，数据库正忙！");
		}
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
