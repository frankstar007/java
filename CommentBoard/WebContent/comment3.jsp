<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>留言板</title>
</head>
<body bgcolor="#FFFFFF" text="#000000">
<p>&nbsp;</p>
<p align="center">
<b><font size="5" color="#FF6633">留言板</font></b></p>
<hr size="1">
<%
	int n;
	String temp = new String();
	String temp1 = new String();
	String temp2 = new String();
	String temp3 = new String();
	
	temp = (String)application.getAttribute("num");
	n = Integer.parseInt(temp);
	if (n == 0) {
%>
	<p>&nbsp;</p>
	<p align="center">目前还没有文章！</p>
	<%
	} else {

	%>
	<table width="60%" border="1" cellspacing="0" cellpadding="5" align="center" bordercolor="#999999">
	<% 
		int i;
		for (i = 0; i <= n; i++) {
			temp = temp.valueOf(i);
			temp1 = (String)application.getAttribute("tit" + temp);
			temp2 = (String)application.getAttribute("aut" + temp);
			temp3 = (String)application.getAttribute("art" + temp);
	%>
	<tr>
		<td bgcolor="#CCFFCC" height="72">
		<b><%=temp %>.标题:<%=temp1 %>.作者：<%=temp2 %></b></td>
	</tr>
	<tr>
		<td><%=temp3 %></td>
	</tr>
<% 
		}
		
	}
	%>	
	</table>
<p align="center">&nbsp;</p>
</body>
</html>