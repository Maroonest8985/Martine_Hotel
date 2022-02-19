package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contactServlet", value = {"/contact","/nae.do"})
public class ContactServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        RequestDispatcher RequestDispatcher = request.getRequestDispatcher("/contact.jsp");
        RequestDispatcher.forward(request, response);        // Hello
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("utf-8");
        String ms = request.getParameter("ms");
        request.setAttribute("ms",ms);
        request.getRequestDispatcher("/contact.jsp").forward(request,response);
    }

    public void destroy() {
    }
}