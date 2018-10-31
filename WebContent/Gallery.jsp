<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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

<style>
* {
    box-sizing: border-box;
}

body {
    margin: 0;
    font-family: Arial;
}

/* The grid: Four equal columns that floats next to each other */
.column {
    float: left;
    width: 25%;
    padding: 10px;
}

/* Style the images inside the grid */
.column img {
    opacity: 0.8; 
    cursor: pointer; 
}

.column img:hover {
    opacity: 1;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* The expanding image container */
.imgcontainer {
    position: relative;
    display: none;
}

/* Expanding image text */
#imgtext {
    position: absolute;
    bottom: 15px;
    left: 15px;
    color: white;
    font-size: 20px;
}

/* Closable button inside the expanded image */
.closebtn {
    position: absolute;
    top: 10px;
    right: 15px;
    color: white;
    font-size: 35px;
    cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
	<div style="text-align:center">
  <h2>Gallery</h2>
  <p>Click on the images below:</p>
</div>

<!-- The four columns -->
<div class="row">
  <div class="column">
    <img src="VehicleImages\trip2.jpg" alt="Trip" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\vehicle1.jpg" alt="Trip" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\images (4).jpg" alt="Trip" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\images (5).jpg" alt="Trip" style="width:100%" onclick="myFunction(this);">
  </div>
  </div>
  
  <div class="row">
  <div class="column">
    <img src="VehicleImages\safari3.jpg" alt="Safari" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\jeep-safari-yala.jpg" alt="Safari" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\tour1.jpg" alt="Safari" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\images (2).jpg" alt="Safari" style="width:100%" onclick="myFunction(this);">
  </div>
</div>

<div class="row">
  <div class="column">
    <img src="VehicleImages\weddings-4.jpg" alt="Wedding" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\weddings-5.jpg" alt="Wedding" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\lucy-wedding.jpg" alt="Wedding" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\untitledmain2.jpg" alt="Wedding" style="width:100%" onclick="myFunction(this);">
  </div>
  </div>
  
  <div class="row">
  <div class="column">
    <img src="VehicleImages\airport-transfers.jpg" alt="Airport" style="width:100%" onclick="myFunction(this);">
  </div>
  
  <div class="column">
    <img src="VehicleImages\home-banner2.jpg" alt="Airport" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\tour2.jpg" alt="Tour" style="width:100%" onclick="myFunction(this);">
  </div>
  <div class="column">
    <img src="VehicleImages\roadtrip3.jpg" alt="Tour" style="width:100%" onclick="myFunction(this);">
  </div>
</div>

<div class="imgcontainer">
  <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>
  <img id="expandedImg" style="width:100%">
  <div id="imgtext"></div>
</div>
	<script>
function myFunction(imgs) {
    var expandImg = document.getElementById("expandedImg");
    var imgText = document.getElementById("imgtext");
    expandImg.src = imgs.src;
    imgText.innerHTML = imgs.alt;
    expandImg.parentElement.style.display = "block";
}
</script>


	</div>
</body>
<%@include file="footer.jsp"%>
</html>