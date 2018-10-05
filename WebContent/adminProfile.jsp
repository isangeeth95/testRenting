<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<%
if(session.getAttribute("username")==null) {
%>
<jsp:include page="header.jsp"></jsp:include>
<%
} else {
%>
<jsp:include page="afterLoginHeader.jsp"></jsp:include>
<%
}%>
</head>
<body>
	<div class="container">
	<table>
	<tr><td><a href="adminViewUsers" />Click here to get users</td></tr>
	<tr><td><a href="adminViewDriver" />Click here to get drivers</td></tr>
	<tr><td><a href="adminRegisterForm.jsp" />Click here to add admins</td></tr>
	</table>

	</div>
</body>
<%@include file="footer.jsp"%>
</html>