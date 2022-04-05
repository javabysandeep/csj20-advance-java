<%--
  Created by IntelliJ IDEA.
  User: sandeepbhingle
  Date: 05/04/22
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="handleError.jsp" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<%
    Integer number1 = Integer.valueOf(request.getParameter("number1"));
    Integer number2 = Integer.valueOf(request.getParameter("number2"));
    String operation = request.getParameter("operation");
    switch (operation) {
        case "+":
            out.println(number1 + number2);
            break;
        case "-":
            out.println(number1 - number2);
            break;
        case "/":
            out.println(number1 / number2);
            break;
        case "*":
            out.println(number1 * number2);
            break;
    }
    out.println("Exception "+exception.getMessage());
%>
</body>
</html>
