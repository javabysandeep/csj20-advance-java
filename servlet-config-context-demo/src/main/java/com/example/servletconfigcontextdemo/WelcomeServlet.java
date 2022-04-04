package com.example.servletconfigcontextdemo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "welcomeServlet", value = "/welcome-servlet", loadOnStartup = 1,
        initParams = {
        @WebInitParam( name="username", value = "vaishanv"),
        @WebInitParam( name="password", value = "vaishanvi")
        })
public class WelcomeServlet extends HttpServlet {
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

        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");

        ServletContext servletContext = getServletContext();
        String usernameContext = servletContext.getInitParameter("username");



        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + " " + username + "</h1><hr>");
        out.println("<h1> Context " + message + " " + usernameContext + "</h1><hr>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}