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
<body >
<form action="AdminServlet" method="get" class="container">
<br><br>
<h1>Umesh</h1>
  <table style="align:center;width:1000px;" class="table">
   <tr>  
   <th>Enter The Email id</th><td><input type='text' name='admin_id'  required="required" placeholder="Enter Admin Id"></td></tr><tr><td></td></tr>
   <tr>
   <th>Enter The Password</th><td> <input type='password' name='admin_pass' required="required" placeholder="Enter Password"></td>
   </tr>
	<tr>
		<td align="center">	<br><br>
			<input type="submit" value="Submit"  class="btn btn-success" required="required">
			<input type="Reset" class="btn btn-info">
		</td>
	</tr>
	<tr><th align="center">
		<a class="btn" class="btn btn-link" href="login.jsp">login</a></th></tr>
	</table>
</form>
</body>
</html>