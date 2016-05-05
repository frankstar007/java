<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="calcBean" class="com.frankstar.study.servlet1.CalculatorBean"/>
<jsp:setProperty property="*" name="calcBean"/>
<%
	calcBean.calculate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用【jsp+javabean开发模式】开发的简单计算器</title>
</head>
<body>
	计算结果是：
	<jsp:getProperty name="calcBean" property="firstNum"/>
	<jsp:getProperty property="operator" name="calcBean"/>
	<jsp:getProperty property="secondNum" name="calcBean"/>
	=
	<jsp:getProperty property="result" name="calcBean"/>
	
	<br><br>
	<form action="${pageContext.request.contextPath }/calculator.jsp" method="post">
		<table border="1px">
			<tr>
				<td colspan="2">简单的计数器</td>
			</tr>
			<tr>
				<td>第一个参数</td>
				<td><input type="text" name="firstNum"></td>
			</tr>
			<tr>
           		<td>运算符</td>
				<td><select name="operator">
					<option value="+">+</option>
					<option value="-">-</option>
					<option value="*">*</option>
					<option value="/">/</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>第二个参数</td>
				<td><input type="text" name="secondNum"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="计算"></td>
			</tr>
		</table>
	</form>
</body>
</html>