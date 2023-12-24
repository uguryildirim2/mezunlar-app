<%@page import="model.Message"%>
<%@page import="java.util.List"%>
<%@page import="database.MessageDao"%>
<%@page import="model.Topic"%>
<%@page import="database.TopicDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String topicId = request.getParameter("topicId");

MessageDao messageDao = new MessageDao();
TopicDao topicDao = new TopicDao();

Topic topic = topicDao.getTopicById(topicId);
List<Message> messages = messageDao.getMessagesByTopicId(topicId);

request.setAttribute("messages", messages);
request.setAttribute("topic", topic);

%>
<!DOCTYPE html>
<html>
<head>
<title>Topic Details</title>
</head>
<body>
	<h1>Topic Details</h1>

	<h2>Topic: ${topic.title}</h2>

	<h3>Messages:</h3>
	<ul>
		<c:forEach var="message" items="${messages}">
			<li>${message.content}</li>
		</c:forEach>
	</ul>

	<form action="servlet" method="post">
		<input type="hidden" name="action" value="addMessage"> 
		<input type="hidden" name="topicId" value="${topic.topicId}">
		<textarea name="messageContent" rows="4" cols="50" required></textarea>
		<br> <input type="submit" value="Add Message">
	</form>
</body>
</html>