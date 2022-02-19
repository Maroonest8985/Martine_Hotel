package com.example.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import com.example.demo.model.MemberDTO;
import com.example.demo.model.ReservationDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.MemberDAOImpl;
import com.example.demo.repository.ReservationDAOImpl;
import com.example.demo.repository.RoomsDAOImpl;

@WebServlet(name = "roomsServlet", value = {"/rooms","/roomsDetail.do", "/reservation.do"})
public class RoomsServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();
        RoomsDAOImpl dao = new RoomsDAOImpl();
        MemberDAOImpl memberDao = new MemberDAOImpl();
        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURL().toString();
        if(url.contains("roomsDetail.do") != false){ //방 하나 조회 소스

            request.setCharacterEncoding("UTF-8");
            int no = Integer.parseInt(request.getParameter("no")); // int형으로 요청해서 받아오는것
            RoomsDTO readList = new RoomsDTO(); //readList라는 방을 만듬
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            String person = request.getParameter("person");

            MemberDTO memberInfo = new MemberDTO();
            String id = (String) session.getAttribute("logined");
            if((readList = (RoomsDTO) dao.readRoomList(no)) != null){ //
                memberInfo = (MemberDTO) memberDao.readMemberListAsId(id);
                request.setAttribute("memberInfo", memberInfo);
                request.setAttribute("readList", readList);
                request.setAttribute("date1", date1);
                request.setAttribute("date2", date2);
                request.setAttribute("person", person);
                request.getRequestDispatcher("/roomsDetail.jsp").forward(request, response);
            }else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/roomsDetail.jsp").forward(request, response);
            }
        }else if(url.indexOf("rooms") != -1){ // 방전체 조회 소스 억빠 씨발련
            ArrayList<RoomsDTO> roomList= new ArrayList<RoomsDTO>();
            if ((roomList = (ArrayList<RoomsDTO>) dao.roomList()) != null) {
                request.setAttribute("roomList", roomList);
                request.getRequestDispatcher("/rooms.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/rooms.jsp").forward(request, response);
            }
        }else if(url.contains("reservation.do") != false){
            ReservationDAOImpl reservationDAO = new ReservationDAOImpl();
            request.setCharacterEncoding("UTF-8");
            int no = Integer.parseInt(request.getParameter("member_no")); //멤버넘버, null이어도 됨
            int room_no = Integer.parseInt(request.getParameter("room_no")); //room_no
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            int person = Integer.parseInt(request.getParameter("person"));
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            String price = request.getParameter("price");
            String card1 = request.getParameter("card1");
            String card2 = request.getParameter("card2");
            String card3 = request.getParameter("card3");
            String card4 = request.getParameter("card4");
            String card = card1 + card2 + card3 + card4;
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setStartday(date1);
            reservationDTO.setEndday(date2);
            reservationDTO.setMember_no(no);
            reservationDTO.setMember_num(person);
            reservationDTO.setName(name);
            reservationDTO.setTel(tel);
            reservationDTO.setCard_no(card);
            reservationDTO.setPrice(price);
            reservationDTO.setRoom_no(room_no);
            if(reservationDAO.insertReservation(reservationDTO) == -1){
                response.sendRedirect("./home");
            }else{
                response.sendRedirect("./blog.jsp");
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    public void destroy() {
    }
}