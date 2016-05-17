<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>为javaBean设置属性值</title>
</head>
<body>
	<jsp:useBean id="person" class="com.frankstar.study.servlet1.Person" scope="page"></jsp:useBean>
	<jsp:setProperty property="name" name="person" value="叶红星"/>
	<jsp:setProperty property="sex" name="person" value="男"/>
	<jsp:setProperty property="age" name="person" value="25"/>
	<jsp:setProperty property="married" name="person" value="false"/>
	<jsp:setProperty property="birthday" name="person" value="<%=new Date() %>"/>

	<h2>姓名：<%=person.getName() %></h2>
	<h2>性别：<%=person.getSex() %></h2>
	<h2>年龄：<%=person.getAge() %></h2>
	<h2>已婚：<%=person.isMarried() %></h2>
	<h2>出生日期: <%=person.getBirthday() %></h2>

</body>
</html>