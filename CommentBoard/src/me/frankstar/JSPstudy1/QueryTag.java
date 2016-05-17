package me.frankstar.JSPstudy1;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class QueryTag extends SimpleTagSupport{
	//标签的属性
	private String driver;
	private String url;
	private String user;
	private String pass;
	private String sql;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private ResultSetMetaData resultSetMetaData = null;
	//属性的设置
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public ResultSetMetaData getResultSetMetaData() {
		return resultSetMetaData;
	}
	public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
		this.resultSetMetaData = resultSetMetaData;
	}
	public ResultSet getResultSet() {
		return resultSet;
	}
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	//重写doTag()
	public void doTag() throws JspException, IOException {
		try {
			//注册驱动
			Class.forName(driver);
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			resultSetMetaData = resultSet.getMetaData();
			
			int columnCount = resultSetMetaData.getColumnCount();
			Writer out = getJspContext().getOut();
			out.write("<table border='1' bgColor='#9999cc' width='400'>");
			//遍历结果
			while (resultSet.next()) {
				out.write("<tr>");
				for (int i = 1; i <= columnCount; i++) {
					out.write("<td>");
					out.write(resultSet.getString(i));
					out.write("</td>");
				}
				out.write("</tr>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JspException("自定义标签错误" + e.getMessage());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new JspException("自定义标签错误" + sqle.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
	}
}
