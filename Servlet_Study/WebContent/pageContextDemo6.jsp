<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用pageContext的include方法引入资源</title>
	
</head>
	<% pageContext.include("/jspfragments/head.jspf"); %>
	<% pageContext.include("/jspfragments/foot.jspf"); %>
<body>
	
	
	
	<hr>
	<jsp:include page="/jspfragments/head.jspf"></jsp:include>
	<jsp:include page="/jspfragments/foot.jspf"></jsp:include>
</body>
</html>