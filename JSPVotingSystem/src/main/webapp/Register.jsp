<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
</head>
<body>

<h3>Register New User</h3>


<form method="post" action="RegisterResult.jsp">


First Name : <input name="fname" type="text">
<br>
<br>
Last Name : <input name="lname" type="text">
<br>
<br>

Email :<input name="email" type="email">
<br>
<br>
Password : <input name="passwd" type="text">
<br>
<br>
DOB : <input name="dob" type="date">
<br>
<br> 
<input type="submit" value="Register">
</form>

</body>
</html>