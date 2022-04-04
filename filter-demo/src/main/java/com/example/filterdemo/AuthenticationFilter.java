package com.example.filterdemo;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "AuthenticationFilter",  urlPatterns = {"/servlet1","/servlet2","/servlet3"})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Inti method of filter");
    }

    public void destroy() {
        System.out.println("Destroy of filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //pre-processing
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("swapi") && password.equals("186")){
            chain.doFilter(request, response);

        } else{
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("login.html");
        }
    }
}
