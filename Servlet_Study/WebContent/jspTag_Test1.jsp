<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/frankstar" prefix="FrankstarTagLibrary" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输出客户端的IP</title>
</head>
<body>
	您的IP地址是：
	<%
		String ip = request.getRemoteAddr();
		out.write(ip);
	%>
	
	<hr/>

		<FrankstarTagLibrary:viewIP/>

</body>
</html>