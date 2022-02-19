package com.example.demo.controller;

import com.example.demo.model.MemberDTO;
import com.example.demo.model.ReservationDTO;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.MemberDAOImpl;
import com.example.demo.repository.ReservationDAOImpl;
import com.example.demo.repository.RestaurantsDAOImpl;
import com.example.demo.repository.RoomsDAOImpl;
import com.example.demo.Pagination;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;


@WebServlet(name = "adminServlet", urlPatterns = {"/admin/main","/admin/roomList.do","/admin/adRoomDetail.do",
        "/admin/roomAdd.do","/admin/roomUpdateForm.do","/admin/roomUpdate.do","/admin/roomDelete.do","/admin/roomAddSubmit.do",
        "/admin/restaurantsList.do","/admin/restaurantsAdd.do","/admin/restaurantsAddSubmit.do","/admin/restaurantsUpdate.do",
        "/admin/adRestaurantsDetail.do", "/admin/restaurantsUpdateForm.do","/admin/restaurantsDelete.do",
        "/admin/memberList.do","/admin/memberDetail.do","/admin/memberUpdate.do","/admin/memberUpdateForm.do",
        "/admin/memberDelete.do","/admin/reservationList.do","/admin/reservationDetail.do","/admin/reservationUpdateForm.do",
        "/admin/reservationUpdate.do","/admin/reservationDelete.do"})

public class AdminServlet extends HttpServlet {

    RoomsDAOImpl dao1 = new RoomsDAOImpl();
    RestaurantsDAOImpl dao = new RestaurantsDAOImpl();
    MemberDAOImpl dao2 = new MemberDAOImpl();
    ReservationDAOImpl dao3 = new ReservationDAOImpl();

    protected void Service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = uri.substring(contextPath.length() + 1); // blogs/post.do, blogs/list.do 가 반환
        String action = command.substring(command.lastIndexOf("/") + 1); // post.do, list.do 반환'

        // 데이터베이스 처리 요청 또는 서비스 요청 코드가 추가

        if (action.equals("main")) {
            request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
        } else if (action.equals("roomList.do")) {

            ArrayList<RoomsDTO> roomList = new ArrayList<RoomsDTO>();
            String pageNo = request.getParameter("pn"); // 매개변수로 전달된 현재 페이지 번호가 정수현으로 저장
            int curPageNo = (pageNo != null)? Integer.parseInt(pageNo):1;
            int perPage = 5; // 한 페이지에 나타나는 행의 수
            int perPagination = 3; // 한 화면에 나타나는 페이지 번호 수

            int totalRows = dao1.readTotalRows(); // dao에서 총 행의 수를 질의함

            Pagination pagination = new Pagination(curPageNo, perPage, perPagination, totalRows);

            if ((roomList = (ArrayList<RoomsDTO>) dao1.readListPagination(pagination)) != null) {
                request.setAttribute("roomList", roomList);
                request.setAttribute("pagination", pagination);
                request.getRequestDispatcher("../admin/roomlist.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/roomlists.jsp").forward(request, response);
            }

        }else if (action.equals("roomAddSubmit.do")) {
            RoomsDTO roomsDTO = new RoomsDTO();

            String path = request.getSession().getServletContext().getRealPath("img");
            System.out.println(path);
            int size = 1024 * 1024 * 10;
            try{
                MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

                roomsDTO.setName(multi.getParameter("name"));
                roomsDTO.setEx(multi.getParameter("ex"));
                roomsDTO.setPrice(multi.getParameter("price"));
                //번호가 지정되있는 데이터베이스(스택) = Enumeration
                Enumeration files = multi.getFileNames();
                String name1 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
                String filename1 = multi.getFilesystemName(name1); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
                String originalFile1 = multi.getOriginalFileName(name1);
                String name2 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
                String filename2 = multi.getFilesystemName(name2); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
                String originalFile2 = multi.getOriginalFileName(name2);
                String name3 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
                String filename3 = multi.getFilesystemName(name3); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
                String originalFile3 = multi.getOriginalFileName(name3);
                //위에가 파일 부분
                System.out.println(filename1);
                System.out.println(filename2);
                System.out.println(filename3);
                roomsDTO.setPic1("img/" + filename3);
                roomsDTO.setPic2("img/" + filename2);
                roomsDTO.setPic3("img/" + filename1);
                System.out.println("success");
            }catch (Exception e){
                e.printStackTrace();
            }
            if (dao1.create(roomsDTO) > 0) {
                response.sendRedirect("../admin/roomList.do");
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../admin/roomAdd.jsp").forward(request, response);
            }
        } else if (action.equals("roomAdd.do")) {
            request.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("../admin/roomAdd.jsp").forward(request, response);
        } else if(action.equals("adRoomDetail.do")){
            request.setCharacterEncoding("UTF-8");

            int no = Integer.parseInt(request.getParameter("no"));

            RoomsDTO roomList = new RoomsDTO();

            if((roomList = (RoomsDTO) dao1.readRoomList(no)) != null){
                request.setAttribute("roomList", roomList);
                request.getRequestDispatcher("../admin/adRoomDetail.jsp").forward(request, response);
            }else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../roomsDetail.jsp").forward(request, response);
            }
        }else if (action.equals("roomUpdateForm.do")) { // update를 위한 정보 조회후 view에게 전달송
            RoomsDTO roomsDTO = new RoomsDTO();
            String strNo = request.getParameter("no");
            int no = Integer.parseInt(strNo);
            roomsDTO.setNo(no);
            RoomsDTO retRoomsDTO = null;
            if ((retRoomsDTO = dao1.readRoomList(no)) != null) {
                request.setAttribute("roomList", retRoomsDTO); // key -> blog
                request.getRequestDispatcher("roomUpdateForm.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "블로그 업데이트를 위한 조회 실패");
                request.getRequestDispatcher("roomUpdateForm.jsp").forward(request, response);
                ; // 오류
            }
        } else if (action.equals("roomUpdate.do")) { // dao에게 업데이트를 요청
            RoomsDTO roomsDTO = new RoomsDTO();

            String path = request.getSession().getServletContext().getRealPath("img");
            System.out.println(path);
            int size = 1024 * 1024 * 10;

            MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
            roomsDTO.setNo(Integer.parseInt(multi.getParameter("no")));
            roomsDTO.setName(multi.getParameter("name"));
            roomsDTO.setEx(multi.getParameter("ex"));
            roomsDTO.setPrice(multi.getParameter("price"));

            Enumeration files = multi.getFileNames();
            String name1 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
            String filename1 = multi.getFilesystemName(name1); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
            String originalFile1 = multi.getOriginalFileName(name1);
            String name2 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
            String filename2 = multi.getFilesystemName(name2); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
            String originalFile2 = multi.getOriginalFileName(name2);
            String name3 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
            String filename3 = multi.getFilesystemName(name3); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
            String originalFile3 = multi.getOriginalFileName(name3);
            //위에가 파일 부분
            System.out.println(filename1);
            System.out.println(filename2);
            System.out.println(filename3);
            roomsDTO.setPic1("img/" + filename3);
            roomsDTO.setPic2("img/" + filename2);
            roomsDTO.setPic3("img/" + filename1);
            System.out.println("success");

            if (dao1.update(roomsDTO) > 0) {
                request.setAttribute("roomsDTO", roomsDTO);
                // 처리 결과를 view에 전달한다. about.jsp -> processok.jsp
                request.getRequestDispatcher("../admin/roomList.do").forward(request, response);
            } else {
                request.getRequestDispatcher("../admin/index.jsp").forward(request, response);
            }
        } else if(action.equals("roomDelete.do")){
            RoomsDTO roomsDTO = new RoomsDTO();
            roomsDTO.setNo(Integer.parseInt(request.getParameter("no")));

            if (dao1.delete(roomsDTO) > 0) {
                request.setAttribute("roomsDTO", roomsDTO);

                request.getRequestDispatcher("../admin/roomList.do").forward(request, response);
            } else {
                request.setAttribute("msg", "블로그 멤버 삭제 실패");
                request.getRequestDispatcher("../admin/roomList.do").forward(request, response);

            }
        }else if (action.equals("restaurantsList.do")) {

            ArrayList<RestaurantsDTO> restaurantsList = new ArrayList<RestaurantsDTO>();

            String pageNo = request.getParameter("pn"); // 매개변수로 전달된 현재 페이지 번호가 정수현으로 저장
            int curPageNo = (pageNo != null)? Integer.parseInt(pageNo):1;
            int perPage = 5; // 한 페이지에 나타나는 행의 수
            int perPagination = 3; // 한 화면에 나타나는 페이지 번호 수

            int totalRows = dao.readTotalRows(); // dao에서 총 행의 수를 질의함

            Pagination pagination = new Pagination(curPageNo, perPage, perPagination, totalRows);

            if ((restaurantsList = (ArrayList<RestaurantsDTO>) dao.readListPagination(pagination)) != null) {
                request.setAttribute("restaurantsList", restaurantsList);
                request.setAttribute("pagination", pagination);
                request.getRequestDispatcher("../admin/restaurantlist.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("/restaurantlist.jsp").forward(request, response);
            }
        } else if (action.equals("restaurantsAddSubmit.do")) {
            RestaurantsDTO restaurantsDTO = new RestaurantsDTO();

            String path = request.getSession().getServletContext().getRealPath("img");
            System.out.println(path);
            int size = 1024 * 1024 * 10;
            try{
                MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

                restaurantsDTO.setName(multi.getParameter("name"));
                restaurantsDTO.setEx(multi.getParameter("ex"));
                restaurantsDTO.setPrice(multi.getParameter("price"));
                //번호가 지정되있는 데이터베이스(스택) = Enumeration
                Enumeration files = multi.getFileNames();
                    String name1 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
                    String filename1 = multi.getFilesystemName(name1); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
                    String originalFile1 = multi.getOriginalFileName(name1);
                    String name2 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
                    String filename2 = multi.getFilesystemName(name2); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
                    String originalFile2 = multi.getOriginalFileName(name2);
                    String name3 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
                    String filename3 = multi.getFilesystemName(name3); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
                    String originalFile3 = multi.getOriginalFileName(name3);
                    //위에가 파일 부분
                    System.out.println(filename1);
                    System.out.println(filename2);
                    System.out.println(filename3);
                    restaurantsDTO.setPic1("img/" + filename3);
                    restaurantsDTO.setPic2("img/" + filename2);
                    restaurantsDTO.setPic3("img/" + filename1);
                System.out.println("success");
            }catch (Exception e){
                e.printStackTrace();
            }
            if (dao.create(restaurantsDTO) > 0) {
                response.sendRedirect("../admin/restaurantsList.do");
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../admin/restaurantAdd.jsp").forward(request, response);
            }
        }else if(action.equals("restaurantsAdd.do")){
            request.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("../admin/restaurantAdd.jsp").forward(request, response);
        } else if(action.equals("adRestaurantsDetail.do")){
            request.setCharacterEncoding("UTF-8");

            int no = Integer.parseInt(request.getParameter("no"));

            RestaurantsDTO restaurantsList = new RestaurantsDTO();

            if((restaurantsList = (RestaurantsDTO) dao.readRestaurantsList(no)) != null){
                request.setAttribute("restaurantsList", restaurantsList);
                request.getRequestDispatcher("../admin/adRestaurantsDetail.jsp").forward(request, response);
            }else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../restaurantsDetail.jsp").forward(request, response);
            }
        }
        else if (action.equals("restaurantsUpdateForm.do")) { // update를 위한 정보 조회후 view에게 전달송
            RestaurantsDTO restaurantsDTO = new RestaurantsDTO();
            String strNo = request.getParameter("no");
            int no = Integer.parseInt(strNo);
            restaurantsDTO.setNo(no);
            RestaurantsDTO retRestaurantsDTO = null;
            if ((retRestaurantsDTO = dao.readRestaurantsList(no)) != null) {
                request.setAttribute("restaurantsList", retRestaurantsDTO); // key -> blog
                request.getRequestDispatcher("restaurantsUpdateForm.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "블로그 업데이트를 위한 조회 실패");
                request.getRequestDispatcher("restaurantsUpdateForm.jsp").forward(request, response);
                ; // 오류
            }
        } else if (action.equals("restaurantsUpdate.do")) { // dao에게 업데이트를 요청
            RestaurantsDTO restaurantsDTO = new RestaurantsDTO();

            String path = request.getSession().getServletContext().getRealPath("img");
            System.out.println(path);
            int size = 1024 * 1024 * 10;

            MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
            restaurantsDTO.setNo(Integer.parseInt(multi.getParameter("no")));
            restaurantsDTO.setName(multi.getParameter("name"));
            restaurantsDTO.setEx(multi.getParameter("ex"));
            restaurantsDTO.setPrice(multi.getParameter("price"));

            Enumeration files = multi.getFileNames();
            String name1 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
            String filename1 = multi.getFilesystemName(name1); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
            String originalFile1 = multi.getOriginalFileName(name1);
            String name2 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
            String filename2 = multi.getFilesystemName(name2); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
            String originalFile2 = multi.getOriginalFileName(name2);
            String name3 = (String)files.nextElement(); //각각의 파일 name을 String name에 담는다.
            String filename3 = multi.getFilesystemName(name3); //각각의 파일 name을 통해서 파일의 정보를 얻는다.
            String originalFile3 = multi.getOriginalFileName(name3);
            //위에가 파일 부분
            System.out.println(filename1);
            System.out.println(filename2);
            System.out.println(filename3);
            restaurantsDTO.setPic1("img/" + filename3);
            restaurantsDTO.setPic2("img/" + filename2);
            restaurantsDTO.setPic3("img/" + filename1);
            System.out.println("success");

            if (dao.update(restaurantsDTO) > 0) {
                request.setAttribute("restaurantsDTO", restaurantsDTO);
                // 처리 결과를 view에 전달한다. about.jsp -> processok.jsp
                request.getRequestDispatcher("../admin/restaurantsList.do").forward(request, response);
            } else {
                request.getRequestDispatcher("../admin/index.jsp").forward(request, response);
            }
        } else if(action.equals("restaurantsDelete.do")){
            RestaurantsDTO restaurantsDTO = new RestaurantsDTO();
            restaurantsDTO.setNo(Integer.parseInt(request.getParameter("no")));

            if (dao.delete(restaurantsDTO) > 0) {
                request.setAttribute("restaurantsDTO", restaurantsDTO);

                request.getRequestDispatcher("../admin/restaurantsList.do").forward(request, response);
            } else {
                request.setAttribute("msg", "블로그 멤버 삭제 실패");
                request.getRequestDispatcher("../admin/restaurantsList.do").forward(request, response);
            }
        }
        else if (action.equals("memberList.do")) {

            ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
            String pageNo = request.getParameter("pn"); // 매개변수로 전달된 현재 페이지 번호가 정수현으로 저장
            int curPageNo = (pageNo != null)? Integer.parseInt(pageNo):1;
            int perPage = 5; // 한 페이지에 나타나는 행의 수
            int perPagination = 3; // 한 화면에 나타나는 페이지 번호 수

            int totalRows = dao2.readTotalRows(); // dao에서 총 행의 수를 질의함

            Pagination pagination = new Pagination(curPageNo, perPage, perPagination, totalRows);

            if ((memberList = (ArrayList<MemberDTO>) dao2.readListPagination(pagination)) != null) {
                request.setAttribute("memberList", memberList);
                request.setAttribute("pagination", pagination);
                request.getRequestDispatcher("../admin/memberlist.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../admin/memberlistsdf.jsp").forward(request, response);
            }
        }else if (action.equals("memberUpdateForm.do")) { // update를 위한 정보 조회후 view에게 전달송
            MemberDTO memberDTO = new MemberDTO();
            String strNo = request.getParameter("no");
            int no = Integer.parseInt(strNo);
            memberDTO.setNo(no);
            MemberDTO retMemberDTO = null;
            if ((retMemberDTO = dao2.readMemberList(no)) != null) {
                request.setAttribute("memberList", retMemberDTO); // key -> blog
                request.getRequestDispatcher("memberUpdateForm.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "블로그 업데이트를 위한 조회 실패");
                request.getRequestDispatcher("memberUpdateForm.jsp").forward(request, response);
                ; // 오류
            }
        } else if (action.equals("memberUpdate.do")) { // dao에게 업데이트를 요청
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setNo(Integer.parseInt(request.getParameter("no")));
            memberDTO.setName(request.getParameter("name"));
            memberDTO.setId(request.getParameter("id"));
            memberDTO.setPwd(request.getParameter("pwd"));
            memberDTO.setRank(Integer.parseInt(request.getParameter("rank")));
            memberDTO.setTel(request.getParameter("tel"));
            memberDTO.setEmail(request.getParameter("email"));


            if (dao2.update(memberDTO) > 0) {
                request.setAttribute("memberDTO", memberDTO);
                // 처리 결과를 view에 전달한다. about.jsp -> processok.jsp
                request.getRequestDispatcher("../admin/memberList.do").forward(request, response);
            } else {
                request.getRequestDispatcher("../admin/index.jsp").forward(request, response);
            }
        } else if(action.equals("memberDelete.do")){
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setNo(Integer.parseInt(request.getParameter("no")));

            if (dao2.delete(memberDTO) > 0) {
                request.setAttribute("memberDTO", memberDTO);

                request.getRequestDispatcher("../admin/memberList.do").forward(request, response);
            } else {
                request.setAttribute("msg", "블로그 멤버 삭제 실패");
                request.getRequestDispatcher("../admin/memberList.do").forward(request, response);

            }
        }else if(action.equals("memberDetail.do")){
            request.setCharacterEncoding("UTF-8");

            int no = Integer.parseInt(request.getParameter("no"));

            MemberDTO memberList = new MemberDTO();

            if((memberList = (MemberDTO) dao2.readMemberList(no)) != null){
                request.setAttribute("memberList", memberList);
                request.getRequestDispatcher("../admin/memberDetail.jsp").forward(request, response);
            }else{
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../memberDetail.jsp").forward(request, response);
            }
        } else if (action.equals("reservationList.do")) {

            ArrayList<ReservationDTO> reservationList = new ArrayList<ReservationDTO>();
            String pageNo = request.getParameter("pn"); // 매개변수로 전달된 현재 페이지 번호가 정수현으로 저장
            int curPageNo = (pageNo != null)? Integer.parseInt(pageNo):1;
            int perPage = 5; // 한 페이지에 나타나는 행의 수
            int perPagination = 3; // 한 화면에 나타나는 페이지 번호 수

            int totalRows = dao3.readTotalRows(); // dao에서 총 행의 수를 질의함

            Pagination pagination = new Pagination(curPageNo, perPage, perPagination, totalRows);

            if ((reservationList = (ArrayList<ReservationDTO>) dao3.readListPagination(pagination)) != null) {
                request.setAttribute("reservationList", reservationList);
                request.setAttribute("pagination", pagination);
                request.getRequestDispatcher("../admin/reservationlist.jsp").forward(request, response);
            } else {
                request.setAttribute("errMsg", "failed");
                request.getRequestDispatcher("../admin/reservationlistsdf.jsp").forward(request, response);
            }
        } else if(action.equals("reservationDetail.do")){
            request.setCharacterEncoding("UTF-8");
            int no = Integer.parseInt(request.getParameter("no"));

            ReservationDTO reservationList = new ReservationDTO();
            if((reservationList = (ReservationDTO)dao3.readReservationList(no))!=null){
                request.setAttribute("reservationList",reservationList);
                request.getRequestDispatcher("../admin/reservationDetail.jsp").forward(request,response);
            }else{
                request.setAttribute("errMsg","failed");
                request.getRequestDispatcher("../admin/reservationDetail.jsp").forward(request,response);
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service(request, response);
    }
}
