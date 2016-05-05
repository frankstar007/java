<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>"></base>
<title>First jsp</title>
</head>
<body>
	<%= new java.util.Date() %>
	<%
		out.print("hello jsp!" + "<br/>");
		session.setAttribute("name", "frankstar");
		out.print(session.getAttribute("name") + "<br/>");
		pageContext.setAttribute("name", "内容");
		out.print(pageContext.getAttribute("name")+"<br/>");//获取pageContext对象的属性
		application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
		out.print(application.getAttribute("name")+"<br/>");//获取application对象的属性
		out.print("Hello Jsp"+"<br/>");//使用out对象
		out.print("服务器调用index.jsp页面时翻译成的类的名字是："+page.getClass()+"<br/>");//使用page对象
		out.print("处理请求的Servlet的名字是："+config.getServletName()+"<br/>");//使用config对象
		out.print(response.getContentType()+"<br/>");//使用response对象
		out.print(request.getContextPath()+"<br/>");//使用req
	%>
</body>
</html>