<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一个javaBean</title>
</head>
<body>
	<jsp:useBean id="person" class="com.frankstar.study.servlet1.Person" scope="page"/>
	<%
		person.setName("叶红星");
		person.setAge(25);
		person.setSex("男");
		person.setMarried(false);
	%>
	
	<h3><%=person.getName() %></h3>
	<h3><%=person.getAge() %></h3>
	<h3><%=person.getSex() %></h3>
	<h3><%=person.isMarried() %></h3>
</body>
</html>