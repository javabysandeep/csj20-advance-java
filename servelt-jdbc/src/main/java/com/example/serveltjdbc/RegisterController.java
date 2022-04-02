package com.example.serveltjdbc;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "registerController", value = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = User.builder()
                .name(name)
                .email(email)
                .username(username)
                .password(password)
                .phone(phone)
                .build();

        UserDao userDao = new UserDao();
        User userRegisterResponse = userDao.registerUser(user);

        PrintWriter writer = resp.getWriter();

        writer.println(userRegisterResponse);

    }
}