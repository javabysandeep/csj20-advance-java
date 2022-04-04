package com.example.servletconfigcontextdemo;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        System.out.println("init method");
        message = "Hello ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("service method");

        // Hello
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = getServletContext();
        String usernameContext = servletContext.getInitParameter("username");

        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + " " + username + "</h1><hr>");
        out.println("<h1> context" + message + " " + usernameContext + "</h1><hr>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}