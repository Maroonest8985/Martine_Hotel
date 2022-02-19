package com.example.demo.controller;

import com.example.demo.model.MemberDTO;
import com.example.demo.model.RoomsDTO;
import com.example.demo.repository.MemberDAO;
import com.example.demo.repository.MemberDAOImpl;
import com.example.demo.repository.RoomsDAOImpl;
import com.example.demo.repository.mysqlConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login.do","/logout.do"})
public class LoginServlet extends HttpServlet {
    MemberDAOImpl dao = new MemberDAOImpl();
    @Override       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();

        String contextPath = request.getContextPath();
        String command = uri.substring(contextPath.length() + 1);
        String action = command.substring(command.lastIndexOf("/") + 1);

        if(action.equals("login.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            MemberDTO member_info = dao.readMemberListAsId(id);
            String member_no = Integer.toString(member_info.getNo());
            if ((dao.memberLogin(id, pwd)) != 0) {
                session.setAttribute("logined", id); // session 처리
                session.setAttribute("member_no", member_no);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "실패 : 회원 로그인 실패하였습니다.");
                request.getRequestDispatcher("/blog.jsp").forward(request, response);
            }
        } else if(action.equals("logout.do")) {
            session.invalidate(); // session 객체를 무효화 함. 즉 logined 속성값이 메모리에서 사라지게 됨
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
