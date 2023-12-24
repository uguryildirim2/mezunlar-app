<%@page import="model.Topic"%>
<%@page import="java.util.List"%>
<%@page import="database.TopicDao"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
TopicDao topicDao = new TopicDao();
List<Topic> topics = topicDao.getAllTopics();
request.setAttribute("topics", topics);
%>
<html>
<head>
<title>List Topics</title>
</head>
<body>
	<h1>Forum Topics</h1>
	<ul>
		<c:forEach var="topic" items="${topics}">
			<li>${topic.title}</li>
		</c:forEach>
	</ul>
</body>
</html>