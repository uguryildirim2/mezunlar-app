<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
HttpSession userSession = request.getSession(false);
User user = (User) userSession.getAttribute("user");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>


	<div class="container">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Mezunlar Platformu</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Ana Sayfa</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="forum/index.jsp">Forum</a></li>


					</ul>
					<div class="d-flex align-items-center">
						<%
						if (user == null) {
						%>
						<div class="px-4">
							<a href="login.jsp">Giriş Yap</a>
						</div>
						<div class="px-4">
							<a href="register.jsp">Kaydol</a>
						</div>
						<%
						}
						%>

						<%
						if (user != null) {
						%>
						<div class="dropdown">
							<button class="btn btn-secondary btn-sm dropdown-toggle"
								type="button" data-bs-toggle="dropdown" aria-expanded="false">
								Profili Görüntüle</button>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Bilgi</a></li>
								<li><a class="dropdown-item" href="logout.jsp">Çıkış</a></li>

							</ul>
						</div>
						<%
						}
						%>

					</div>
				</div>
			</div>
		</nav>
		<h1>Hello, world!</h1>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>