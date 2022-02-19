package com.example.demo.controller;

import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.RestaurantsDAOImpl;
import com.example.demo.repository.RoomsDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "restaurantsServlet", value = {"/restaurants","/restaurantsDetail.do"})
public class RestaurantsServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RestaurantsDAOImpl dao = new RestaurantsDAOImpl();
        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURL().toString();
        if(url.contains("restaurantsDetail.do") != false){

            request.setCharacterEncoding("UTF-8");

            int no = Integer.parseInt(request.getParameter("no"));

            RestaurantsDTO restaurantsList = new RestaurantsDTO();

            if((restaurantsList = (RestaurantsDTO) dao.readRestaurantsList(no)) != null){
                request.setAttribute("restaurantsList", restaurantsList);
                request.getRequestDispatcher("/restaurantsDetail.jsp").forward(request, response);
            }else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/restaurantsDetail.jsp").forward(request, response);
            }
        }else if(url.indexOf("restaurants") != -1){

            ArrayList<RestaurantsDTO> restaurantsList= new ArrayList<RestaurantsDTO>();

            if ((restaurantsList = (ArrayList<RestaurantsDTO>) dao.restaurantsList()) != null) {
                request.setAttribute("restaurantsList", restaurantsList);
                request.getRequestDispatcher("/restaurants.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/restaurants.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    public void destroy() {
    }
}