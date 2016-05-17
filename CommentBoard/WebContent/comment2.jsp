<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>留言板</title>
<script type="text/javascript">
	function MM_openBrWindow(theURL,winName,features) {
		window.open(theURL,winName,features);
	}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000">
<p>&nbsp;</p>
<p align="center">
	<b><font size="5" color="#FF6633">留言板</font></b>
</p>
<hr size="1">
<%
	int n;
	String temp = new String();
	String temp1 = new String();
	String temp2 = new String();
	String temp3 = new String();
	
	temp1 = request.getParameter("txttit");
	temp2 = request.getParameter("txtaut");
	temp3 = request.getParameter("txtart");
	
	n = temp1.length() * temp2.length() * temp3.length();
	if (n != 0) {
		temp = (String)application.getAttribute("num");
		n = Integer.parseInt(temp);
		n = n + 1;
		temp = temp.valueOf(n);
		application.setAttribute("num", temp);
		application.setAttribute("tit" + temp, temp1);
		application.setAttribute("aut" + temp, temp2);
		application.setAttribute("art" + temp, temp3);
		%>
		<p>&nbsp;</p>
		<p align="center">留言成功！</p>
		<% 
		} 
	else {
		%>
		<p align="center">
		<font color="#FF00000">不添加作者、标题和内容，留言失败！</font></p>
		<% 
	}
%>
<p align="center"><a href="comment3.jsp">返回首页</a><p>
</body>
</html>