package com.example.demo.controller;

import com.example.demo.Pagination;
import com.example.demo.model.MemberDTO;
import com.example.demo.model.ReservationDTO;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "homeServlet", value = {"/home", "/title.do", "/registration.do", "/checkid.do","/reok.do"})
public class HomeServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        MemberDAOImpl dao = new MemberDAOImpl();
        ReservationDAOImpl dao1 = new ReservationDAOImpl();
        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = uri.substring(contextPath.length() + 1); // blogs/post.do, blogs/list.do 가 반환
        String action = command.substring(command.lastIndexOf("/") + 1); // post.do, list.do 반환'
        HttpSession session = request.getSession();

        if(url.contains("registration.do") != false){
            MemberDTO memberDTO = new MemberDTO();
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String email =  request.getParameter("email");
            String tel = request.getParameter("tel");
            Integer rank = 1; // rank == 1일때 회원, rank == 0 일때 비회원
            memberDTO.setName(name);
            memberDTO.setId(id);
            memberDTO.setPwd(pwd);
            memberDTO.setEmail(email);
            memberDTO.setTel(tel);
            memberDTO.setRank(rank);

            if((dao.insertMember(memberDTO)) != -1){
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/roomsDetail.jsp").forward(request, response);
            }else{
                response.sendRedirect("./home");//request.getRequestDispatcher는 url에 변동이 없어
                //registration.do로 재이동이 되어 가입 데이터가 두번 들어가는 문제가 발생. 따라서 response.sendRedirect
                //메서드 사용했음.
            }
        }else if(url.contains("checkid.do")){
            String id = request.getParameter("userid");//front-end에서 ajax로 받아온 parameter
            response.getWriter().write(dao.checkMember(id)+"");
        }else if(url.contains("home")){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else if (action.equals("reok.do")) {
            ArrayList<ReservationDTO> reservationList = new ArrayList<ReservationDTO>();

            String member_no = (String)session.getAttribute("member_no");
            if(member_no == null){
                String name = request.getParameter("rename");
                String tel = request.getParameter("retel");
                if ((reservationList = (ArrayList<ReservationDTO>) dao1.readReservationListAsName(name, tel)) != null) {
                    request.setAttribute("reservationList", reservationList);
                    request.getRequestDispatcher("/reok.jsp").forward(request, response);
                }else{
                    request.setAttribute("errMsg", "failed");
                    request.getRequestDispatcher("/index123.jsp").forward(request, response);
                }
            }else if ((reservationList = (ArrayList<ReservationDTO>) dao1.readReservationListAsMemberNo(member_no)) != null) {
                request.setAttribute("reservationList", reservationList);
                request.getRequestDispatcher("/reok.jsp").forward(request, response);
            } else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/index123.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}