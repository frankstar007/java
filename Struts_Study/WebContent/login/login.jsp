<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
    			+ request.getServerPort() + path + "/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基于Struts2的登陆系统应用</title>
</head>
<body>
	<s:form  action="login">
		用户名：<input name="username" key="user" type="text" size="24">
		<br>
		密 码：<input name="password" type="password" size="26">
		<br>
		<input type="submit" value="登录">
	</s:form>
</body>
</html>