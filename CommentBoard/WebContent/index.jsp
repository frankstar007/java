<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session对象的应用</title>
</head>
<script language="javascript" type="text/javascript">
	function MyCheck() {
		if (form.account.value == "") {
			alert("请输入用户名：");
			form.account.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("请输入密码：");
			form.password.focus();
			return false;
		}
		form.submit();
  }
</script>
<body>
	<table width="334" height="171" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td><br>
			<form name="form" method="post" action="dealwith.jsp?method=0" onSubmit="return MyCheck()">
				<table>
					<tr>
					<td width="62" height="20">用户名:</td>
					<td width="172">
					<input name="account" type="text" id="account">
					</td>
					</tr>
					<tr>
					<td height="20">密&nbsp;&nbsp;&nbsp;码:</td>
					<td><input name="password" type="password" id="password"></td>
					</tr>
					<tr>
					<td height="20" colspan="2">
						<div align="center">
							<input type="submit" name="Submit" value="登录">&nbsp;&nbsp;
							<input type="reset" name="Submit2" value="重置">
						</div>
					</td>
					</tr>
				</table>
			</form>
			</td>
			</tr>
	</table>
</body>
</html>