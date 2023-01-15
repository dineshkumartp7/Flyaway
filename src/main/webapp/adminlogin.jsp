<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Login</title>
</head>
<body>

	<form action="AdminLogin" method="post">
		USERNAME : <input type="email" name="username" required="required"><br>
		PASSWORD : <input type="password" name="password" required="required"><br>
		<button type="submit">Login</button> 
	</form>

</body>
</html>