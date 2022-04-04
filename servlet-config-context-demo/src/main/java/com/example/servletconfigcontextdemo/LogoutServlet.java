package com.example.servletconfigcontextdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        response.setContentType("text/html");
        httpSession.invalidate();
        response.getWriter().println("Logout Successfully!!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
        requestDispatcher.include(request, response);
    }
}
