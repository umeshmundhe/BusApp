<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body bgcolor="pink"  >

<marquee bgcolor="red" loop="" behavior="scroll"> Welcome to Bus Scheduling Application</marquee>


<form action="UserServlet" method="Post" id=passenger class="container">
<BR><BR><BR>

<div align="center" style="vertical-align:bottom">
<table class="table" border="1" style="align:center;width:300px;"  >
		<tr><th>
<select name="src" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" autofocus="autofocus">
<option hidden="1">  Source </option>
<option value="1">Alandi</option>
<option value="2">Charoli</option>
<option value="3">Saibaba</option>
<option value="4">Magzin </option>
<option value="5">Dighi </option>
<option value="6">Kalas </option>
<option value="7">Wadi </option>
<option value="8">Mental Cornar</option>
<option value="9">Deccan collage</option>
<option value="10">Shivaji Nagar</option>
<option value="11">Corporation </option>
	</select><br>
		</th></tr>
<tr><th>
<select name="dst" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" autofocus="autofocus">
<option hidden="1">destination </option>
<option value="1">Alandi</option>
<option value="2">Charoli</option>
<option value="3">Saibaba</option>
<option value="4">Magzin </option>
<option value="5">Dighi </option>
<option value="6">Kalas </option>
<option value="7">Wadi </option>
<option value="8">Mental Cornar</option>
<option value="9">Deccan collage</option>
<option value="10">Shivaji Nagar</option>
<option value="11">Corporation </option>
</select>
</th></tr>
<tr><th>
<input type="Submit" value="Submit" class="btn btn-success" autofocus="autofocus">

<input type="Reset" class="btn btn-info" autofocus="autofocus">
</th></tr>


</Table>
</div>
<div align="center" style="vertical-align:bottom"> <img src="images/im.jpg" align="middle"  class="img-responsive"></div>

</form>

</body>
</html>