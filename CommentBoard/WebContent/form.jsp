<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单测试</title>
</head>
<body>
<form id="form1" method="post" action="request1.jsp">
		用户名：<input type="text" name="name"> <hr>
		性别：<br>
		男：<input type="radio" name="gender" value="男">
		 女:	<input type="radio" name="gender" value="女">
		 	<hr>
		 喜欢的颜色 ：<br>
		 红:<input type="checkbox" name="color" value="红色">
		 绿:<input type="checkbox" name="color" value="绿色">
		 蓝:<input type="checkbox" name="color" value="蓝色">
		 <hr>
		 来自的国家：<br/>
		 <select name="country">
		 	<option value="AA">AAA</option>
		 	<option value="BB">BBB</option>
		 	<option value="CC">CCC</option>
		 </select><hr>
		 <input type="submit" value="提交">
		 <input type="reset" value="重置">
		 
	</form>
</body>
</html>