package com.example.demo.repository;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.Pagination;


public class RoomsDAOImpl extends DAOImplMysql implements RoomsDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public RoomsDAOImpl() {
        conn = getConn();
    }

    @Override
    public List<RoomsDTO> roomList() {
        String sqlQuery = "SELECT * FROM room";
        ArrayList<RoomsDTO> roomList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            roomList = new ArrayList<RoomsDTO>();
            while (rs.next()) {
                RoomsDTO room = new RoomsDTO(); // roomlist->방 리스트 저장공간
                room.setNo(rs.getInt("no"));
                room.setName(rs.getString("name"));
                room.setEx(rs.getString("ex"));
                room.setPrice(rs.getString("price"));
                room.setPic1(rs.getString("pic1"));
                room.setPic2(rs.getString("pic2"));
                room.setPic3(rs.getString("pic3"));
                roomList.add(room);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    @Override
    public RoomsDTO readRoomList(int no) {
        RoomsDTO readList = null;
        try {
            String sqlQuery = "SELECT * FROM room WHERE no = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            readList = new RoomsDTO();
            while (rs.next()) {
                readList.setNo(rs.getInt("no"));
                readList.setName(rs.getString("name"));
                readList.setEx(rs.getString("ex"));
                readList.setPrice(rs.getString("price"));
                readList.setPic1(rs.getString("pic1"));
                readList.setPic2(rs.getString("pic2"));
                readList.setPic3(rs.getString("pic3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readList;
    }

    @Override
    public List<RoomsDTO> searchList(String date1, String date2) {
        String sqlQuery = "SELECT * from room where no not in " +
                "(SELECT DISTINCT room_no FROM `reservation_room` " +
                "WHERE startday BETWEEN ? and ?" +
                " or endday between ? and ?)";
        ArrayList<RoomsDTO> searchList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, date1);
            pstmt.setString(2, date2);
            pstmt.setString(3, date1);
            pstmt.setString(4, date2);
            rs = pstmt.executeQuery();
            searchList = new ArrayList<RoomsDTO>();
            while (rs.next()) {
                RoomsDTO room = new RoomsDTO(); // roomlist->방 리스트 저장공간
                room.setNo(rs.getInt("no")); // SQL문이 room테이블 기준이므로 no로 조회
                room.setName(rs.getString("name"));
                room.setEx(rs.getString("ex"));
                room.setPrice(rs.getString("price"));
                room.setPic1(rs.getString("pic1"));
                room.setPic2(rs.getString("pic2"));
                room.setPic3(rs.getString("pic3"));
                searchList.add(room);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return searchList;
    }

    @Override
    public int readTotalRows() {
        int rows = 0;
        String sqlQuery = "select count(*) as totalRows from room";
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
    public List<RoomsDTO> readListPagination(Pagination pagination) {
        ArrayList<RoomsDTO> roomList = null;
        String sqlQuery = "SELECT * FROM (SELECT @rownum:=@rownum+1 as rnum, A.* FROM room A WHERE (@rownum:=0)=0 order by no)rd where rnum >= ? and rnum <= ?;";
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, pagination.getFirstRow());
            pstmt.setInt(2, pagination.getEndRow());
            rs = pstmt.executeQuery();
            // execute(sql)는 모든 질의에 사용가능, executeQuery(sql)는 select에만, executeUpdate()는 insert, update, delete에 사용 가능
            roomList = new ArrayList<RoomsDTO>();
            while (rs.next()) {
                RoomsDTO room = new RoomsDTO();
                room.setNo(rs.getInt("no")); // SQL문이 room테이블 기준이므로 no로 조회
                room.setName(rs.getString("name"));
                room.setEx(rs.getString("ex"));
                room.setPrice(rs.getString("price"));
                room.setPic1(rs.getString("pic1"));
                room.setPic2(rs.getString("pic2"));
                room.setPic3(rs.getString("pic3"));
                roomList.add(room);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    @Override
    public int create(RoomsDTO roomsDTO) {
        String sqlQuery = "INSERT INTO `room`(`name`, `ex`, `price`, `pic1` ,`pic2`, `pic3`) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        int rows = 0;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, roomsDTO.getName());
            pstmt.setString(2, roomsDTO.getEx());
            pstmt.setString(3, roomsDTO.getPrice());
            pstmt.setString(4,roomsDTO.getPic1());
            pstmt.setString(5,roomsDTO.getPic2());
            pstmt.setString(6,roomsDTO.getPic3());

            rows = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int update(RoomsDTO roomsDTO){
        String sqlQuery ="update room set name=?,ex=?,price=?,pic1=?,pic2=?,pic3=? where no=?";
        int rows=0;
        try{
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(7, roomsDTO.getNo());
            pstmt.setString(1, roomsDTO.getName());
            pstmt.setString(2, roomsDTO.getEx());
            pstmt.setString(3, roomsDTO.getPrice());
            pstmt.setString(4, roomsDTO.getPic1());
            pstmt.setString(5, roomsDTO.getPic2());
            pstmt.setString(6, roomsDTO.getPic3());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int delete(RoomsDTO roomsDTO) {
        String sql = "delete from room where no=?";
        int rows = 0; //질의 처리 결과 영향받은 행의 수
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomsDTO.getNo());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
}

