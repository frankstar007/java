<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/frankstars" prefix="referer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>防盗链</title>
</head>
<body>
<referer:referer site="http://localhost:8080" page="/index.jsp"/>

<h3>试试看</h3>
</body>
</html>