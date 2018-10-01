<%@page import="register.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="getUserForUpdate.css">
<title>Get User</title>
</head>
<%
	if (session.getAttribute("username") == null) {
%>
<jsp:include page="header.jsp"></jsp:include>
<%
	} else {
%>
<jsp:include page="afterLoginHeader.jsp"></jsp:include>
<%
	}
%>
<body>
	<div class="container">

		<h2>Update User Information</h2>
		<br> <br>
		<%
		User user=(User)request.getAttribute("user");
	%>
	
	<h1><%=user.getUid() %></h1>
	<h1><%=user.getFname() %></h1>

		<div class="form">
			<form action="updateUserServlet" method="post" enctype="multipart/form-data">
				<table class="table">
					
					<tr>
						<td>User ID</td>
						<td><input id="input" type="text"
							value="<%=user.getUid() %>" name="uid" disabled="disabled"></td>
					</tr>	
					<tr>
						<td>First Name</td>
						<td><input id="input" type="text"
							value="<%=user.getFname() %>" name="fname"></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input id="input" type="text"
							value="Nimal" name="lname"></td>
					</tr>
					<tr>
						<td>E mail</td>
						<td><input id="input" type="text"
							value="<%=user.getEmail() %>" name="email"></td>
					</tr>
					<tr>
						<td></td>
						<td style="font-size: 20px; color: red;">${emailErr}</td>
					</tr>
					<tr>
						<td>Gender</td>
						<td><input style="height: 20px; width: 20px;" type="radio"
							name="gender" value="female">female <input
							style="height: 20px; width: 20px;" type="radio" name="gender"
							value="male">male</td>
					</tr>
					<tr>
						<td>Country</td>
						<td><input id="input" type="text" value="<%=user.getCountry() %>"
							name="country"></td>
					</tr>
					<tr>
						<td>City</td>
						<td><input id="input" type="text" value="<%=user.getCity() %>"
							name="city"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input id="input" type="text"
							value="<%=user.getTelNo() %>" name="telNo"></td>
					</tr>
					<tr>
						<td>User name</td>
						<td><input id="input" type="text"
							value="<%=user.getUname() %>" name="uname"></td>
					</tr>
					<tr>
						<td></td>
						<td style="font-size: 25px; color: red;">${unameExist}</td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input id="input" type="password"
							value="<%=user.getPassword() %>" name="password"></td>
					</tr>
					<tr>
						<td>Confirm password</td>
						<td><input id="input" type="password"
							placeholder="Confirm the Password" name="confirmPassword"
							required></td>
					</tr>
					<tr>
						<td></td>
						<td style="font-size: 25px; color: red;">${passwordMatchingErr}</td>
					</tr>
					<tr>
						<td>Upload Image</td>
						<td><input id="input" type="file" value="<%=user.getImageName() %>" name="image"></td>
					</tr>


				</table>
				<br /> <input type="submit" value="Update" name="submitButton"
					id="sButton">
			</form>
		</div>

		<h1 style="font-size: 40px; color: red;">${insertUnsuccess}</h1>

		<table>
			<tr>
				<td colspan="2">
					<form method="POST" action="DeleteEmployeeServlet">
						<input type="hidden" name="employeeID"
							value="<%=user.getUid() %>" /> <input type="submit"
							value="Delete Employee" class="delete-button" />
					</form>
				</td>
			</tr>
		</table>






	</div>
</body>
<%@include file="footer.jsp"%>
</html>