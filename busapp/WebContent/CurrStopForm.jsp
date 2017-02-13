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


<body>
<form action="CurrStopServlet" method="Post" id=currloc class="container" autocomplete="on">

<div align="center" style="vertical-align:bottom;">
<table class="table" border="1" style="align:center;width:400px; margin-top:250px">
	<tr><th>
<select name="curr" class="btn btn-info dropdown-toggle" data-toggle="dropdown" autofocus="autofocus">
<option hidden="0">Current Location </option>
<option value="1">Alandi</option>
<option value="2">Charoli</option>
<option value="3">Saibaba</option>
<option value="4">Magzin </option>
<option value="5">Dighi </option>
<option value="6">Kalas </option>
<option value="7">Wadi </option>
<option value="8">Mental Cornar</option>
<option value="9">Deccan collager</option>
<option value="10">Shivaji Nagar</option>
<option value="11">Corporation </option>
</select>
</th></tr>

<tr><th>
<input type="Submit" value="Submit" name="ok" class="btn btn-success">

<input type="Reset" class="btn btn-primary">

<input type="Submit" value="LastStop" name="ok" class="btn btn-info">
<input type="Submit" value="Logout" name="ok" class="btn btn-danger">

</th></tr></table></div></form>
</body>
</html>