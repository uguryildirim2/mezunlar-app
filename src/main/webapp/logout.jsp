<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession userSession = request.getSession(false);
    if (userSession != null) {
        userSession.invalidate(); // Oturumu sonlandır
    }
    response.sendRedirect("index.jsp"); // Giriş sayfasına yönlendir
%>