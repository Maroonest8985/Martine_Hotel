package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "blogServlet", value = {"/blog","/blogger.do"})
public class BlogServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher RequestDispatcher = request.getRequestDispatcher("/blog.jsp");
        RequestDispatcher.forward(request, response);        // Hello
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("utf-8");
        String blog = request.getParameter("blog");
        request.setAttribute("blog",blog);
        request.getRequestDispatcher("/blog.jsp").forward(request,response);
    }

    public void destroy() {
    }
}