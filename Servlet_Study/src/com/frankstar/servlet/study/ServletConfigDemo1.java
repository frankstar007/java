package com.frankstar.servlet.study;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletConfigDemo1")
public class ServletConfigDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config; //定义ServletConfig对象来接收配置的初始化参数  
   
    public void init(ServletConfig config) {
    	this.config = config;
    }
    public ServletConfigDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取在web.xml中配置的初始化参数
		String paraVal = this.config.getInitParameter("name");
		response.getWriter().print("name:" + paraVal);
		response.getWriter().print("\n");
		//获取所有的初始化参数
		Enumeration<String> enumeration = config.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			String value = config.getInitParameter(name);
			response.getWriter().print(name + "=" + value + "\n");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
