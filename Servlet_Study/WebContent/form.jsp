<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form表单</title>
	<script type="text/javascript">
		var isCommited = false;
		function dosubmit() {
			if (isCommited == false) {
				isCommited = true;
				return true;
			} eles {
				return false;
			}
		}
	
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/DoFormServlet" onsubmit="return dosubmit()" method="post">
		用户名：<input type="text" name="userName">
		<input type="submit" value="提交" id="submit">
	</form>
</body>
</html>