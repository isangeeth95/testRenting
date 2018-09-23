<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="header.jsp"%>
<body>
	<div style="height: 50%;width: 50%;margin-top: 250px;margin-left: 200px;margin-bottom: 200px;padding: 30px;border:1px solid black">
	<form action="./ViewDriver">
		<table>
			<tr>
				<td>Enter the user name : </td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
<%@include file="footer.jsp"%>
</html>