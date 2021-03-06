<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext访问其他域</title>
</head>
<%
	pageContext.setAttribute("name", "叶红星", PageContext.SESSION_SCOPE);
%>
<%
	String name11 = (String)pageContext.getAttribute("name", PageContext.SESSION_SCOPE);
	String name22 = (String)session.getAttribute("name");
%>
<body>
	<h1>
		第一种取法：使用pageContext.getAttribute("attributeName",PageContext.SESSION_SCOPE);去取出session对象中值
	</h1>
	<h3>姓名：<%=name11 %></h3>
	<h1>
		第二种取法：使用session.getAttribute("attributeName");去取出session对象中值
	</h1>
	<h3>姓名：<%=name22 %></h3>
</body>
</html>