package com.example.demo.controller;

import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.RoomsDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchServlet", value = "/search.do")
public class SearchServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RoomsDAOImpl dao = new RoomsDAOImpl();
        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURL().toString();
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        String person = request.getParameter("person");
        if(url.contains("search.do") != false){
            ArrayList<RoomsDTO> searchList = new ArrayList<RoomsDTO>();

            if((searchList = (ArrayList<RoomsDTO>) dao.searchList(date1, date2)) != null){
                request.setAttribute("searchList", searchList);
                request.setAttribute("date1", date1);
                request.setAttribute("date2", date2);
                request.setAttribute("person", person);
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
