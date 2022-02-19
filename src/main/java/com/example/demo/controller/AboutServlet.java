package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "aboutServlet", value = "/about")
public class AboutServlet extends HttpServlet {
    private String message;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher RequestDispatcher = request.getRequestDispatcher("/about.jsp");
        RequestDispatcher.forward(request, response);        // Hello
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    public void destroy() {
    }
}