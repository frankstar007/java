<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBean测试</title>
</head>
<body>	
	<jsp:useBean id="person1" class="com.frankstar.study.servlet5.Person" scope="page">
	<jsp:setProperty name="person1" property="name" value="frankstar"/>
	<jsp:setProperty name="person1" property="age" value="25"/>
	<jsp:getProperty name="person1" property="name"/><br/>
	<jsp:getProperty name="person1" property="age"/><br/>
	</jsp:useBean>

</body>
</html>