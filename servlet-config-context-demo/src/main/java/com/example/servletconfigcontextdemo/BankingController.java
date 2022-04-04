package com.example.servletconfigcontextdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BankingController", value = "/login")
public class BankingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = null;
        PrintWriter writer = response.getWriter();
        if (username.equals("abc") && password.equals("abc")) {
            session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account");
            requestDispatcher.forward(request,response);
        } else{
            writer.println("invalid creds");
        }

    }
}
