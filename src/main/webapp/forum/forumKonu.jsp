<%@page import="model.ForumMesaj"%>
<%@page import="dao.ForumDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<%
    int topicId = Integer.parseInt(request.getParameter("topicId"));
    ForumDao forumDao = new ForumDao();
    List<ForumMesaj> messages = forumDao.getMessagesByTopic(topicId);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forum Topic</title>
</head>
<body>
    <h2>Forum Topic</h2>
    <ul>
        <c:forEach var="message" items="${messages}">
            <li>${message.messageText}</li>
        </c:forEach>
    </ul>

    <form action="postMessage.jsp" method="post">
        <input type="hidden" name="topicId" value="<%= topicId %>">
        <textarea name="messageText" rows="4" cols="50" required></textarea>
        <br>
        <input type="submit" value="Post Message">
    </form>
</body>
</html>