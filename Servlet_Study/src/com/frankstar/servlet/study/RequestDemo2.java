package com.frankstar.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo2
 */
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pWriter = response.getWriter();
		pWriter.write("获取到的客户端的所有请求头信息如下：");
		pWriter.write("<br/>");
		Enumeration<String> reqHeadInfos = request.getHeaderNames();
		while (reqHeadInfos.hasMoreElements()) {
			String headName = reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);
			pWriter.write(headName + "=" + headValue);
			pWriter.write("<br/>");
		}
		//获取客户端Accept-Encoding请求头
		pWriter.write("获取客户端Accept-Encoding请求头");
		pWriter.write("<br/>");
		Enumeration<String> enumeration = request.getHeaders("Accept-Encoding");
		while (enumeration.hasMoreElements()) {
			String reString = enumeration.nextElement();
			pWriter.write(reString);
			pWriter.write("<br/>");
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
