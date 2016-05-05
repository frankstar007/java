<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext的查找属性值</title>
</head>
<%
	pageContext.setAttribute("name1", "叶红星");
	request.setAttribute("name2", "叶红胜");
	session.setAttribute("name3", "李舒雅");
	application.setAttribute("name4", "陈刚");
%>
<%	
	String name11 = (String)pageContext.findAttribute("name1");
	String name22 = (String)pageContext.findAttribute("name2");
	String name33 = (String)pageContext.findAttribute("name3");
	String name44 = (String)pageContext.findAttribute("name4");
	String name55 = (String)pageContext.findAttribute("name5");
%>
<body>
	<h1>pageContext.findAttribute方法查找到的属性值：</h1>
	<h3>pageContext对象的name1属性：<%=name11%></h3>
	<h3>request对象的name2属性：<%=name22%></h3>
	<h3>session对象的name3属性：<%=name33%></h3>
	<h3>application对象的name4属性：<%=name44%></h3>
	<h3>查找不存在的name5属性：<%=name55%></h3>
	<hr>
	<h1>使用EL表达式进行输出：</h1>
	<h3>pageContext对象的name1属性：${name1}</h3>
	<h3>request对象的name2属性：${name2}</h3>
	<h3>session对象的name3属性：${name3}</h3>
	<h3>application对象的name4属性：${name4}</h3>
	<h3>不存在的name5属性：${name5}</h3>
</body>
</html>