<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@include file="header.jsp" %>
</head>
<body>
<div class="container">
<form method="post" action="loginCheck">
		<table>
			<tr>
				<td style="color:blue;">User name</td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	
	<h1>${message}</h1>
</div>	
</body>
<%@include file="footer.jsp" %>
</html>