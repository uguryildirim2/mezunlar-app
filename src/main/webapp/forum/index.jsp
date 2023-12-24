<!-- index.jsp -->
<%@page import="model.Topic"%>
<%@page import="database.TopicDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ForumKonu"%>
<%@page import="dao.ForumDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%
TopicDao topicDao = new TopicDao();
List<Topic> topics = topicDao.getAllTopics();
request.setAttribute("topics", topics);

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-9">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>

</body>
</html>
<body>
	<h2>Forum Konular</h2>
	<ul>
		<c:forEach var="topic" items="${topics}">
			<li><a href="topicDetails.jsp?topicId=${topic.topicId}">${topic.title}</a></li>
		</c:forEach>
	</ul>
	
	<%-- Yeni başlık oluşturma formu --%>
	<h3>Yeni Başlık Oluştur</h3>
	<div>
	 <form action="forum" method="post">
        <input type="hidden" name="action" value="createTopic">
        Topic Title: <input type="text" name="topicTitle" required>
        <input type="submit" value="Başlık Oluştur">
    </form>
    </div>
	
	<form action="createForum" method="post">
		Başlık: <input type="text" name="title" required><br> <input
			type="submit" value="Başlık Oluştur">
	</form>
</body>
</html>