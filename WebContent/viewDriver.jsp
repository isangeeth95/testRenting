<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

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

<body >
	<div align="center" class="container" style="height: 30%; width: 75%; margin-top: 250px; margin-bottom: 20px; padding: 30px; border: 1px solid black;background-image: linear-gradient(to top, #fad0c4 0%, #ffd1ff 100%);">

		<div>

			<%
				if (session != null) {
					if (session.getAttribute("username") != null) {
						String fname = (String) session.getAttribute("fname");
						String lname = (String) session.getAttribute("lname");
						out.print("<h1>Hello "+fname+" "+lname+"  Welcome you on behalf of Yamuda Raumak<h1>");
					} else {
						response.sendRedirect("driverLogin.jsp");
					}
				}
			String imageName = (String) session.getAttribute("imageName");
			if(imageName==null)
				imageName="defaultUser.png";
			String uname=(String)session.getAttribute("username");
			%>
			<br>
			<table>
				<tr>
					<td><img src="usersImages/<%=imageName%>" width="400"
						height="400"></td>
				</tr>
				
			</table>
			<br>
			<abbr style="font-size: 30px;">
			Thank you for registering as a driver in our company.Your service is needed to promote our company.Hense you have to
			give your service to customer in good manner.
			</abbr>
			<form action="ViewDriver">
				<table>
					<tr>
						<br>
						<br>
						<td colspan="1"><input type="submit"
							value="Click to see your frofile" style="padding: 10px;font-size: 30px;"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
<%@include file="footer.jsp"%>
</html>