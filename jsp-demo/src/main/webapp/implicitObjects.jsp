<%--
  Created by IntelliJ IDEA.
  User: sandeepbhingle
  Date: 05/04/22
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello implicit objects</h1>

  <%
    String username = request.getParameter("username");
    String initParameter = config.getInitParameter("username");
    String initParameter1 = application.getInitParameter("username");
    response.sendRedirect("www.google.com");
    session.invalidate();
    out.println("some text");

  %>
</body>
</html>
