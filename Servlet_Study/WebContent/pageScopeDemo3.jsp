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
		String name = (String) pageContext.getAttribute("name");
		Date date = (Date) pageContext.getAttribute("date");
	%>
	 <h1>姓名：<%=name%></h1>
	 <h1>日期：<%=date%></h1>
</body>
</html>