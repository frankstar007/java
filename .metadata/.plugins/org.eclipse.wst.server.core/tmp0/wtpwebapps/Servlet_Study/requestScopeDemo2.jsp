<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String) request.getAttribute("name");
		Date date = (Date) request.getAttribute("date");
		
	%>
	
	<h1>姓名：<%=name %></h1>
	<h2>日期：<%=date %></h2>
</body>
</html>