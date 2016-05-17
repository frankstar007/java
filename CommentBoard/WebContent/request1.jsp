<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取post提交的参数</title>
</head>
<body>
	<%
		//获取所有请求头的名称
		Enumeration<String> headerString = request.getHeaderNames();
		while(headerString.hasMoreElements()) {
			String headerName = headerString.nextElement();
			//获取每个请求及其对应的值
			out.println(headerName + "-->" + request.getHeader(headerName) + "<br>");
		}
		out.println("<hr>");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] color = request.getParameterValues("color");
		String national = request.getParameter("country");
		
	%>
	名字：<%=name %><br>
	性别：<%=gender %><br>
	您喜欢的颜色：
	<%
	for (String c : color) {
		out.println(c + " ");
	}
	%>
	<hr>
	来自的国家：
	<%=national %>
</body>
</html>