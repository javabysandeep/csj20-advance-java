package com.example.servletconfigcontextdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession httpSession = request.getSession(false);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Welcome " + httpSession.getAttribute("username"));

        printWriter.println("<a href=" + "\"logout\">Logout</a>");
    }
}
