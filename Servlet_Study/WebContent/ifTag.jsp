<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/frankstars" prefix="iftag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>if标签测试</title>
</head>
<body>
	<iftag:demo7 test="true">
		<h3>内部网站资料</h3>
	</iftag:demo7>
	<hr/>
	<iftag:demo7 test="false">这个不输出</iftag:demo7>
</body>
</html>