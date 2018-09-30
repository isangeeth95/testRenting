<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>--- This is Driver Login</h3>
<br>
<form action="DriverLoginCheck" method="post">
<table align="center">
	<tr>
		<td>User name</td>
		<td><input type="text" name="uname" required></td>
	</tr>
	<tr>
		<td>User Password</td>
		<td><input type="password" name="password" required></td>
	</tr>
	<tr>
		<td></td>
		<td style="font-size: 20px;color:red;">${message}</td>
	</tr>
	<tr>
	<br/><td><input type="submit" value="Sign In" name="submitButton"></td>
	</tr>
</table>
</form>
</body>
</html>