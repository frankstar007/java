<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jspIncludeDemo3</h1>
	<jsp:include page="/jspfragments/Inc.jsp">
		<jsp:param value="hello" name="parm1"/>
		<jsp:param value="frankstar" name="parm2"/>
	</jsp:include>
	
</body>
</html>