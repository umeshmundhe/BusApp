<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Home Page of Conductor</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%
request.getSession().removeAttribute("session");
request.getSession().removeAttribute("sess");
	String conductor = String.valueOf(session.getAttribute("conductor"));
	out.print(""+conductor);
%>
	<div align="center" style="vertical-align:bottom">
	<form action="HomePageServlet" method="post" class="container">
	<table class="table" style="align:left; width:200px">
	<tr><th>
<select name="bno" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" autofocus="autofocus">
<option hidden="1">Bus_No</option>
<option value="101">101</option>
<option value="102">102</option>
	</select>
	</th></tr>

	<tr><th>
<select name="trip" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" autofocus="autofocus">
<option hidden="1">Route</option>
<option value="A-C">Alandi-Corporation</option>
<option value="C-A">Corporation-Alandi</option>
	</select>
	</th></tr>
		<tr><th width="300">
<input type="Submit" class="btn btn-success"value="Submit">

<input type="Reset" class="btn btn-info">
<input type="submit" value="Logout" name="ok" class="btn btn-danger">
		</th></tr>
	</table>
	</form>
	</div>
</body>
</html>