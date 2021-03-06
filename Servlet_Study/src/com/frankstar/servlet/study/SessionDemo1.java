package com.frankstar.servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo1
 */
@WebServlet("/SessionDemo1")
public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//使用request对象的getSession获取session 如果不存在就创建一个
		HttpSession session = request.getSession();
		//将数据存储到session中
		session.setAttribute("userName", "叶红星");
		//获取session的id
		 String sessionId = session.getId();
		 //判断session是不是新建的
		 if (session.isNew()) {
			 response.getWriter().write("session创建成功，sessionID＝" + sessionId);
		 } else {
			 response.getWriter().write("服务器存在该session其ID为" + sessionId);
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
