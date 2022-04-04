<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    //scrpitlet tag
    //whatever we write inside this will be part of service method of converted Servlet
            /*PrintWriter printWriter = response.getWriter();
            printWriter.println("Hello from JSP");*/
    out.println("JSP Objects");//implicit jsp objects. These objects are already created.
    out.println(LocalDateTime.now());
%>
<hr>
<table>
    <%
        for (int i = 1; i <= 10; i++) {

    %>

    <tr>

        <%
            for (int j = 1; j <= 10; j++) {
        %>
        <td>
            <% out.print(i * j + "\t"); %>
        </td>
        <% System.out.print(i * j + "\t");

        } %>

    </tr>
    <% out.println();
        System.out.println();
    }
    %>
</table>

<%="welcome to Java".toUpperCase()%>
<%=10 + 30 * 50%>
<%! boolean isTrue = false;%>
<%=isTrue ? "Its true" : "its false"%>
</body>
</html>