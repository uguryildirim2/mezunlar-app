<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.Cookie"%>

<!DOCTYPE html>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Home</h1>

	<%
	HttpSession userSession = request.getSession(false);	
	User user = (User) userSession.getAttribute("user");

	if (user != null) {
	%>
	<p>
		Welcome,
		<%=user.getUsername()%>!
	</p>
	<a href="logout.jsp">Logout</a>
	<%
	} else {
	%>
	<p>Please login to access the home page.</p>
	<a href="login.jsp">Login</a>
	<%
	}
	%>
</body>
</html>