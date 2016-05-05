<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="/ErrorPage/error.jsp"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试page指令的errorPage属性</title>
</head>
<body>
	<%	
		int x = 1/0;
	%>
</body>
</html>