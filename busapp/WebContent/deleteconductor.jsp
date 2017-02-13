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
<form action="DeleteConductor" method="post" class="container">
<table><tr><th>
Enter Conductor Id </th> 
<td>
<input type=Text name=delId value="" required="required" placeholder="Enter Conductor id" ></td><td>
<input type="Submit" value="Delete"  class="btn btn-danger" required="required" ></td></tr></table>
</form>

</body>
</html>