package com.frankstar.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得客机信息
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String queryString = request.getQueryString();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String remoteUser = request.getRemoteUser();
		String remotePort = request.getRemoteHost();
		String method = request.getMethod();
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr();
		String localName = request.getLocalName();
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("请求的URL地址：" + requestUrl + "<br/>");
		printWriter.write("请求的资源: " + requestUri + "<br/>");
		printWriter.write("请求的URL地址中附带的参数:" + queryString + "<br/>");
		printWriter.write("来访者的IP：" + remoteAddr + "<br/>");
		printWriter.write("来访者的主机名: " + remoteHost + "<br/>");
		printWriter.write("使用的端口号:" + remotePort + "<br/>");
		printWriter.write("来访者:" + remoteUser + "<br/>");
		printWriter.write("使用的方法：" + method + "<br/>");
		printWriter.write("pathInfo: " + pathInfo + "<br/>");
		printWriter.write("localAddr:" + localAddr + "<br/>");
		printWriter.write("localName:" + localName + "<br/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
