<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Driver</title>
</head>
<body>
		<%
		if(session != null){
			if(session.getAttribute("username")!= null){
				String dfname = (String) session.getAttribute("fname");
				String dlname = (String)session.getAttribute("lname");
				String demail = (String)session.getAttribute("email");
				String dNIC = (String)session.getAttribute("NIC");
				String dmobile = (String)session.getAttribute("mobile");
				String dpassword = (String)session.getAttribute("password");
				String duser = (String)session.getAttribute("username");
				out.print("Hello " + dfname + " " + dlname + " Welcome ");
				
				request.setAttribute("uname", duser);
				request.setAttribute("fname", dfname);
				request.setAttribute("lname", dlname);
				request.setAttribute("email", demail);
				request.setAttribute("mobile", dmobile);
				request.setAttribute("nic", dNIC);
				request.setAttribute("pass", dpassword);
			}
			else{
				response.sendRedirect("driverLogin.jsp");
			}
		}
		%>
	<table border='1'>
		<form action="UpdateDriver" method="post">
		<tr>
		<td>User Name</td><td><input type="text" value='${uname}' name="uname"></td><td><input type="submit" value="Update"></td>
		</tr>
		<tr>
		<td>First Name</td><td><input type="text" value='${fname}' name="fname"></td><td><input type="submit" value="Update"></td>
		</tr>
		<tr>
		<td>Last Name</td><td><input type="text" value='${lname}' name="lname"></td><td><input type="submit" value="Update"></td>
		</tr>
		<tr>
		<td>E-mail</td><td><input type="text" value='${email}' name="email"></td><td><input type="submit" value="Update"></td>
		</tr>
		<tr>
		<td>Mobile</td><td><input type="text" value='${mobile}' name="mobile"></td><td><input type="submit" value="Update"></td>
		</tr>
		<tr>
		<td>NIC</td><td><input type="text" value='${nic}' name="NIC"></td><td><input type="submit" value="Update"></td>
		</tr>
		<tr>
		<td>Password</td><td><input type="password" value='${pass}' name="password"></td><td><input type="submit" value="Update"></td>
		</tr>
		</form>
	</table>
</body>
</html>