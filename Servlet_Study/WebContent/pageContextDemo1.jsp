<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	//此属性只能够在本页中获取
	pageContext.setAttribute("name", "叶红星");
	pageContext.setAttribute("date", new Date());

%>

<%
	//取得属性
	String name = (String)pageContext.getAttribute("name");
	Date date = (Date)pageContext.getAttribute("date");
%>
<body>
	姓名：<%=name %>
	日期：<%=date %>
	
</body>
</html>