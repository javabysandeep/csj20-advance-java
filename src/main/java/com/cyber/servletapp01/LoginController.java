package com.cyber.servletapp01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Web container calls public service method by passing, servletRequest, servletResponse
        // public service method converts these objects into httpServletRequest & httpServletResponse & calls protected service method
        // protected service method calls doXXX based http request method type

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        PrintWriter writer = resp.getWriter();

        if(username.equals("abc") && password.equals("abc")){
            System.out.println("Welcome");
            writer.println("Welcome");
        } else{
            System.out.println("Invalid credentials");
            writer.println("invalid credentials");
        }

    }
}
