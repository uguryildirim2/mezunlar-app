<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form action="user" method="post">
		<input type="hidden" name="action" value="registerUser">
		Username: <input type="text" name="username" required><br>
		Password: <input type="password" name="password" required><br>
		<input type="submit" value="Register">
	</form>
	<p>${message}</p>
</body>
</html>