<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage=""%>
    <%@taglib uri="http://www.frankstar.org/mytaglib" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签示范</title>
</head>
<body bgcolor="#ffffc0">
<h2>下面显示的是查询标签的结果</h2>
	
	<mytag:query user="root" pass="frankstar" 
	url="jdbc:mysql://localhost:3306/JavaStudy" 
	sql="select * from account" 
	driver="com.mysql.jdbc.Driver"/>
	<br/>
</body>
</html>