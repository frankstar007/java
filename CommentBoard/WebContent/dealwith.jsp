<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session对象的应用</title>
</head>
<body>
	<%
		int method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			String account = request.getParameter("account");
			//account = new String();
			session.setAttribute("account", account);
			String password = request.getParameter("password");
			session.setAttribute("password", password);
			response.sendRedirect("forward.jsp");
		}
		if (method == 1) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	%>
</body>
</html>