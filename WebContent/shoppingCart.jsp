<%@page import="shoppingCart.Order"%>
<%@page import="Login.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="getUser.css">
<title>Shopping Cart</title>
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
	<div class="containerForUserDetails">

		<br>
		<br>

		<div class="userDetails" align="left">
			<table border="1" cellpadding="12">
				<%
					Order order = (Order) request.getAttribute("order");
				DBManager db=new DBManager();
				Connection conn=db.getConnection();
				Statement stmt = conn.createStatement();
				
					
				%>
				<caption>
					<h2>
						Details of
						<%=session.getAttribute("username")%>'s Order
					</h2>
				</caption>
				<tr>
					<th>Vehicle ID</th>
					<th>Rent category</th>
					<th>Duration</th>
					<th>Total Cost</th>
					<th>Image</th>
				</tr>

				<tr>
					<td><%=order.getVehicleId()%></td>
					<td><%=order.getRentCategory()%></td>
					<td><%=order.getDuration()%></td>
					<td><%=order.getCost()%></td>
					<td><img src="rentVehiclesImages/<%=order.getImageName() %>"
						width="300" height="200"></td>

				</tr>

			</table>
		</div>

	</div>
</body>
<%@include file="footer.jsp"%>
</html>