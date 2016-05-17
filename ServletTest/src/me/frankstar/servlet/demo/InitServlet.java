package me.frankstar.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String driver = "";
	private String URL = "";
	private String username = "";
	private String password = "";
	
	public void init() throws ServletException {
		driver = getInitParameter("driver");
		URL = getInitParameter("URL");
		username = getInitParameter("username");
		password = getInitParameter("username");
	}
	
	//获得数据库连接
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL,username,password);
			System.out.println("2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
//    public InitServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection connection = this.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {
				out.print(resultSet.getString("id"));
				out.print("\t");
				out.println(resultSet.getString("name"));
				out.print("\t");
				out.println(resultSet.getString("money"));
				out.println("<br>");
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		finally {
			// TODO: handle finally clause
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
