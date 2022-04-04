package com.example.servletconfigcontextdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieDemo", value = "/cookie")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies.length !=0){
            for (Cookie cookie:cookies) {
                System.out.println(cookie.getName()+"\t"+cookie.getValue());
                response.sendRedirect("index.jsp");
            }
        } else {
            Cookie cookie = new Cookie("product","mobile");
            PrintWriter writer = response.getWriter();
            writer.println("Welcome to cookie store");
            response.addCookie(cookie);
        }



    }


}
