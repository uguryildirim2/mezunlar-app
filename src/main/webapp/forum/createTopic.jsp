<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Create Topic</title>
</head>
<body>
    <h1>Create a New Topic</h1>
    <form action="forum" method="post">
        <input type="hidden" name="action" value="createTopic">
        Topic Title: <input type="text" name="topicTitle" required>
        <input type="submit" value="Create">
    </form>
</body>
</html>