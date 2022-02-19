package com.example.demo.repository;
import com.example.demo.Pagination;
import com.example.demo.model.ReservationDTO;
import com.example.demo.model.RestaurantsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl extends DAOImplMysql implements ReservationDAO{
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ReservationDAOImpl() {conn = getConn();}

    @Override
    public int insertReservation(ReservationDTO reservationDTO){
        try{
            String sqlQuery = "INSERT INTO reservation_room(`member_no`, `room_no`, `startday`," +
            "`endday`, `price`, `card_no`, `member_num`,`name`,`tel`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, reservationDTO.getMember_no());//Int
            pstmt.setInt(2, reservationDTO.getRoom_no());//Int
            pstmt.setString(3, reservationDTO.getStartday());
            pstmt.setString(4, reservationDTO.getEndday());
            pstmt.setString(5, reservationDTO.getPrice());
            pstmt.setString(6, reservationDTO.getCard_no());
            pstmt.setInt(7, reservationDTO.getMember_num());//Int
            pstmt.setString(8,reservationDTO.getName());
            pstmt.setString(9,reservationDTO.getTel());
            pstmt.executeUpdate();
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return -1;
    }
    @Override
    public List<ReservationDTO> reservationList() {
        String sqlQuery = "SELECT * FROM reservation_room";
        ArrayList<ReservationDTO> reservationList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            reservationList = new ArrayList<ReservationDTO>();
            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO(); // roomlist->방 리스트 저장공간
                reservation.setNo(rs.getInt("no"));
                reservation.setMember_no(rs.getInt("member_no"));
                reservation.setRoom_no(rs.getInt("room_no"));
                reservation.setStartday(rs.getString("startday"));
                reservation.setEndday(rs.getString("endday"));
                reservation.setPrice(rs.getString("price"));
                reservation.setCard_no(rs.getString("card_no"));
                reservation.setMember_num(rs.getInt("member_num"));
                reservation.setName(rs.getString("name"));
                reservation.setTel(rs.getString("tel"));
                reservationList.add(reservation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservationList;
    }

    @Override
    public ReservationDTO readReservationList(int no) {
        ReservationDTO reservationList = null;
        try {
            String sqlQuery = "SELECT * FROM reservation_room WHERE no = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            reservationList = new ReservationDTO();
            while (rs.next()) {
                reservationList.setNo(rs.getInt("no"));
                reservationList.setMember_no(rs.getInt("member_no"));
                reservationList.setRoom_no(rs.getInt("room_no"));
                reservationList.setStartday(rs.getString("startday"));
                reservationList.setEndday(rs.getString("endday"));
                reservationList.setPrice(rs.getString("price"));
                reservationList.setCard_no(rs.getString("card_no"));
                reservationList.setMember_num(rs.getInt("member_num"));
                reservationList.setName(rs.getString("name"));
                reservationList.setTel(rs.getString("tel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservationList;
    }
    @Override
    public ArrayList<ReservationDTO> readReservationListAsName(String name, String tel){
        ArrayList<ReservationDTO> reservationList = null;
        try{
            String sqlQuery = "SELECT * FROM reservation_room WHERE name = ? and tel = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, name);
            pstmt.setString(2, tel);
            rs = pstmt.executeQuery();
            reservationList = new ArrayList<ReservationDTO>();
            while(rs.next()){
                ReservationDTO reservation = new ReservationDTO();
                reservation.setNo(rs.getInt("no"));
                reservation.setMember_no(rs.getInt("member_no"));
                reservation.setRoom_no(rs.getInt("room_no"));
                reservation.setStartday(rs.getString("startday"));
                reservation.setEndday(rs.getString("endday"));
                reservation.setPrice(rs.getString("price"));
                reservation.setCard_no(rs.getString("card_no"));
                reservation.setMember_num(rs.getInt("member_num"));
                reservation.setName(rs.getString("name"));
                reservation.setTel(rs.getString("tel"));
                reservationList.add(reservation);
            }
    }catch(SQLException e){
            e.printStackTrace();
        }
        return reservationList;
    }
    @Override
    public ArrayList<ReservationDTO> readReservationListAsMemberNo(String member_no) {
        ArrayList<ReservationDTO> reservationList = null;
        try {
            String sqlQuery = "SELECT * FROM reservation_room WHERE member_no = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, member_no);
            rs = pstmt.executeQuery();
            reservationList = new ArrayList<ReservationDTO>();
            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO();
                reservation.setNo(rs.getInt("no"));
                reservation.setMember_no(rs.getInt("member_no"));
                reservation.setRoom_no(rs.getInt("room_no"));
                reservation.setStartday(rs.getString("startday"));
                reservation.setEndday(rs.getString("endday"));
                reservation.setPrice(rs.getString("price"));
                reservation.setCard_no(rs.getString("card_no"));
                reservation.setMember_num(rs.getInt("member_num"));
                reservation.setName(rs.getString("name"));
                reservation.setTel(rs.getString("tel"));
                reservationList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservationList;
    }
    @Override
    public int update(ReservationDTO reservationDTO){
        String sqlQuery ="update reservation_room set member_no=?,room_no=?,startday=?,endday=?,price=?,card_no=?,member_num=?,name=?,tel=? where no=?";
        int rows=0;
        try{
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(10, reservationDTO.getNo());
            pstmt.setInt(1, reservationDTO.getMember_no());
            pstmt.setInt(2, reservationDTO.getRoom_no());
            pstmt.setString(3, reservationDTO.getStartday());
            pstmt.setString(4, reservationDTO.getEndday());
            pstmt.setString(5, reservationDTO.getPrice());
            pstmt.setString(6,reservationDTO.getCard_no());
            pstmt.setInt(7,reservationDTO.getMember_num());
            pstmt.setString(8,reservationDTO.getName());
            pstmt.setString(9,reservationDTO.getTel());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int delete(ReservationDTO reservationDTO) {
        String sql = "delete from reservation_room where no=?";
        int rows = 0; //질의 처리 결과 영향받은 행의 수
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reservationDTO.getNo());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int readTotalRows() {
        int rows = 0;
        String sqlQuery = "select count(*) as totalRows from reservation_room";
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            // execute(sql)는 모든 질의에 사용가능, executeQuery(sql)는 select에만, executeUpdate()는 insert, update, delete에 사용 가능
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rows = rs.getInt("totalRows");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<ReservationDTO> readListPagination(Pagination pagination) {
        ArrayList<ReservationDTO> reservationList = null;
        String sqlQuery = "SELECT * FROM (SELECT @rownum:=@rownum+1 as rnum, A.* FROM reservation_room A WHERE (@rownum:=0)=0 order by no)rd where rnum >= ? and rnum <= ?;";
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, pagination.getFirstRow());
            pstmt.setInt(2, pagination.getEndRow());
            rs = pstmt.executeQuery();
            // execute(sql)는 모든 질의에 사용가능, executeQuery(sql)는 select에만, executeUpdate()는 insert, update, delete에 사용 가능
            reservationList = new ArrayList<ReservationDTO>();
            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO(); // roomlist->방 리스트 저장공간
                reservation.setNo(rs.getInt("no")); // SQL문이 room테이블 기준이므로 no로 조회
                reservation.setMember_no(rs.getInt("member_no"));
                reservation.setRoom_no(rs.getInt("room_no"));
                reservation.setStartday(rs.getString("startday"));
                reservation.setEndday(rs.getString("endday"));
                reservation.setPrice(rs.getString("price"));
                reservation.setCard_no(rs.getString("card_no"));
                reservation.setMember_num(rs.getInt("member_num"));
                reservation.setName(rs.getString("name"));
                reservation.setTel(rs.getString("tel"));
                reservationList.add(reservation);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reservationList;
    }

}
