<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>
</head>
<body>

<h2>Login Page</h2>

<form method="post" action="LoginResult.jsp">



Email :<input name="email" type="email">
<br>
<br>
Password : <input name="passwd" type="text">
<br>
<br>
<input type="submit" value="Login">
<a href="Register.jsp">Register New User</a>
</form>
</body>
</html>