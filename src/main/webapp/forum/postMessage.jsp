<%@page import="dao.ForumDao"%>
<%@page import="model.ForumMesaj"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
    int topicId = Integer.parseInt(request.getParameter("topicId"));
    String messageText = request.getParameter("messageText");

    ForumMesaj message = new ForumMesaj();
    message.setTopicId(topicId);
    message.setMessageText(messageText);

    ForumDao forumDao = new ForumDao();
    // Burada bir mesajı veritabanına eklemek için bir metodun olması beklenir.
    // Örneğin, forumDao.postMessage(message);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Message</title>
</head>
<body>
    <h2>Message Posted</h2>
    <p>Your message has been posted.</p>
    <a href="forumKonu.jsp?topicId=<%= topicId %>">Back to Topic</a>
</body>
</html>