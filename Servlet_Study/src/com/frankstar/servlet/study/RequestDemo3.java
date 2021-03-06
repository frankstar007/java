package com.frankstar.servlet.study;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo3
 */
@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");
		String hiddenField = request.getParameter("hiddenField");
		String instStr = "";
		for (int i = 0; insts != null && i < insts.length; i++) {
			if (i == insts.length - 1) {
				instStr += insts[i];
			} else {
				instStr += insts[i] + ",";
			}
		}
		String htmlStr = "<table>" + 
				"<tr><td>填写的编号：</td><td>{0}</td></tr>" +
				 "<tr><td>填写的用户名：</td><td>{1}</td></tr>" +
				 "<tr><td>填写的密码：</td><td>{2}</td></tr>" +
				 "<tr><td>选中的性别：</td><td>{3}</td></tr>" +
				 "<tr><td>选中的部门：</td><td>{4}</td></tr>" +
				 "<tr><td>选中的兴趣：</td><td>{5}</td></tr>" +
				 "<tr><td>填写的说明：</td><td>{6}</td></tr>" +
				 "<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" +
				 "</table>";
		htmlStr = MessageFormat.format(htmlStr, userid, username,
				userpass, sex, dept, instStr, note, hiddenField);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.getWriter().write(htmlStr);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
