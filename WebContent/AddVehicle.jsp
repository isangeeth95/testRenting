<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="vehicle.css">
<title>Insert vehicle</title>
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
		<h1 style="text-align: center; font-size: 50px">Register your
			vehicle...</h1>
		<div class="form">
			<form action="addVehicle" method="post" enctype="multipart/form-data">
				<table class="table">

					<tr>
						<td>Vehicle Model :</td>
						<td><input style="height: 20px; width: 20px;" type="radio"
							name="type" value="car"> Car <input
							style="height: 20px; width: 20px;" type="radio" name="type"
							value="jeep">Jeep <input
							style="height: 20px; width: 20px;" type="radio" name="type"
							value="van">Van <input
							style="height: 20px; width: 20px;" type="radio" name="type"
							value="bus">Bus</td>

					</tr>

					<tr>
						<td>Cost per day :</td>
						<td><input id="input" type="number" min="0" max="50000" name="costPerDay" required></td>
					</tr>

					<tr>
						<td>Cost per KM :</td>
						<td><input id="input" type="number" min="0" max="5000" placeholder="Rs:25.00/="
							name="costPerKM" required></td>

					</tr>

					<tr>
						<td>Vehicle Image</td>
						<td><input id="input" type="file" name="imageName" required></td>
					</tr>

					<tr>
						<td>Rent Category :</td>
						<td><input style="height: 20px; width: 20px;" type="radio"
							name="rentCategory" value="wedding"> WEDDING <input
							style="height: 20px; width: 20px;" type="radio" name="rentCategory"
							value="air-port">AIR PORT<input
							style="height: 20px; width: 20px;" type="radio" name="rentCategory"
							value="tour">TOUR
					</tr>


				</table>
				<br /> <input type="submit" value="Add Vehicle To Rent" name="submitButton"
					id="sButton">
			</form>
		</div>

		<h1 style="font-size: 40px; color: red;">${insertUnsuccess}</h1>
	</div>

</body>
<%@include file="footer.jsp"%>
</html>