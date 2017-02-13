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
<form action="RegisterServlet" method="post" class="container">
<table class="table"><tr><th>
 		Enter Conductor Id </th> <td><input type=Text name=RegId value="" required="required" placeholder="Enter Conductor id" ></td></tr>
 		
 		<tr><th>
   		Enter Conductor Name </th><td><input type=Text name=RegName value="" required="required" placeholder="Enter Conductor name">
   		</td></tr>
   		<tr>
   		<th>
   		Enter Email</th>
   		<td> <input type=Text name=RegMail  required="required" placeholder="Enter Email Id">
   		</td>
   		</tr>
   		<tr>
   		<th>
    	Enter The Password	</th>
    	<td><input type=Password name=RegPass value="" required="required"  placeholder="Enter Password">
  		</td>
  		</tr>
 
  <tr><td>
    	 	<input type="Submit" value="Submit" class="btn btn-success" value="" required="required" ><th>  </th><th>   </th> <td>
			<tr><td><input type="Reset" class="btn btn-primary"></td>
			
			</tr>
   </table>
   <a class="btn" class="btn btn-link" href="deleteconductor.jsp">register</a>
</form>

</body>
</html>