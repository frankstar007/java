package com.frankstar.servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 使用servletContext读取资源文件
 * Servlet implementation class ServletContextDemo6
 */
@WebServlet("/ServletContextDemo6")
public class ServletContextDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextDemo6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置相应内容编码
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		readSrcDirPropCfgFile(response);//读取src目录下的properties文件
		response.getWriter().println("<hr/>");
		readWebRootDirPropCfgFile(response);//读取web根目录下的properties文件
		response.getWriter().println("<hr/>");
		readPropCfgFile(response);//读取src目录下的db.config目录下的文件
		response.getWriter().println("<hr/>");
		readPropCfgFile2(response);//读取src目录下的当前包中的文件
	}

	private void readPropCfgFile2(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/frankstar/servlet/study/db4.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String propertyID = properties.getProperty("propertyID");
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		response.getWriter().println("读取src目录下的com.frankstar.servlet.study包中的db4.properties配置文件：");
		response.getWriter().println(
		     MessageFormat.format(
		                        "propertyID={0},name={1},password={2}", 
		                        propertyID,name, password));
	}

	private void readPropCfgFile(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void readWebRootDirPropCfgFile(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void readSrcDirPropCfgFile(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
