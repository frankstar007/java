<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page language="java" import="java.util.Date"%>
<%@taglib uri="/frankstars" prefix="simple" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>复合类型标签属性</title>
</head>
<body>
	<%--  <simple:demo6 date="1991-02-03"/>--%>
	<%
		Date date = new Date();
		request.setAttribute("date", date);
	%>
	<simple:demo6 date="${date }"/>
	<hr/>
	<simple:demo6 date="<%=new Date() %>"/>
</body>
</html>