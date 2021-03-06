package com.frankstar.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置服务器以UTF-编码进行输出
		response.setCharacterEncoding("UTF-8");
		//设置浏览器以UTF－8编码接收 解决中文乱码问题
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		//获取浏览器访问服务器时传递过来的Cookie数组
		Cookie[] cookies = request.getCookies();
		//如果用户是第一次访问 那么得到的cookie将是null
		if (cookies != null) {
			printWriter.write("您上次访问的时间：");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					printWriter.write(date.toLocaleString());
				}
			}
		} else {
			printWriter.write("您师第一次访问本站！");
		}
		//用户访问过后重新设置用户的访问时间 存储到cookie中
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
