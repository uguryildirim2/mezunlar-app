<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum Sayfası</title>
</head>
<body>
    <h2>Forum</h2>

    <%-- Başlıkları listele --%>
    <ul>
        <c:forEach var="topic" items="${topics}">
            <li>
                <strong>${topic.title}</strong> -
                <em>Yazar: ${topic.author.username}</em><br>
                ${topic.content}
            </li>
        </c:forEach>
    </ul>

    <hr>

    <%-- Yeni başlık oluşturma formu --%>
    <h3>Yeni Başlık Oluştur</h3>
    <form action="createTopic" method="post">
        Başlık: <input type="text" name="title" required><br>
        İçerik: <textarea name="content" required></textarea><br>
        <input type="submit" value="Başlık Oluştur">
    </form>
</body>
</html>