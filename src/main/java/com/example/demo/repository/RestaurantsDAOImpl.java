package com.example.demo.repository;
import com.example.demo.Pagination;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsDAOImpl extends DAOImplMysql implements RestaurantsDAO{
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public RestaurantsDAOImpl() {
        conn = getConn();
    }

    @Override
    public List<RestaurantsDTO> restaurantsList() {
        String sqlQuery = "SELECT * FROM restaurant";
        ArrayList<RestaurantsDTO> restaurantsList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            restaurantsList = new ArrayList<RestaurantsDTO>();
            while (rs.next()) {
                RestaurantsDTO restaurants = new RestaurantsDTO(); // roomlist->방 리스트 저장공간
                restaurants.setNo(rs.getInt("no"));
                restaurants.setName(rs.getString("name"));
                restaurants.setEx(rs.getString("ex"));
                restaurants.setPrice(rs.getString("price"));
                restaurants.setPic1(rs.getString("pic1"));
                restaurants.setPic2(rs.getString("pic2"));
                restaurants.setPic3(rs.getString("pic3"));
                restaurantsList.add(restaurants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restaurantsList;
    }

    @Override
    public RestaurantsDTO readRestaurantsList(int no) {
        RestaurantsDTO restaurantsList = null;
        try {
            String sqlQuery = "SELECT * FROM restaurant WHERE no = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            restaurantsList = new RestaurantsDTO();
            while (rs.next()) {
                restaurantsList.setNo(rs.getInt("no"));
                restaurantsList.setName(rs.getString("name"));
                restaurantsList.setEx(rs.getString("ex"));
                restaurantsList.setPrice(rs.getString("price"));
                restaurantsList.setPic1(rs.getString("pic1"));
                restaurantsList.setPic2(rs.getString("pic2"));
                restaurantsList.setPic3(rs.getString("pic3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantsList;
    }

    @Override
    public List<RestaurantsDTO> searchList(String date1, String date2) {
        String sqlQuery = "SELECT * from restaurant where no not in " +
                "(SELECT DISTINCT restaurant FROM `reservation_room` " +
                "WHERE startday BETWEEN ? and ?" +
                " or endday between ? and ?)";
        ArrayList<RestaurantsDTO> searchList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, date1);
            pstmt.setString(2, date2);
            pstmt.setString(3, date1);
            pstmt.setString(4, date2);
            rs = pstmt.executeQuery();
            searchList = new ArrayList<RestaurantsDTO>();
            while (rs.next()) {
                RestaurantsDTO restaurants = new RestaurantsDTO(); // roomlist->방 리스트 저장공간
                restaurants.setNo(rs.getInt("no")); // SQL문이 room테이블 기준이므로 no로 조회
                restaurants.setName(rs.getString("name"));
                restaurants.setEx(rs.getString("ex"));
                restaurants.setPrice(rs.getString("price"));
                restaurants.setPic1(rs.getString("pic1"));
                restaurants.setPic2(rs.getString("pic2"));
                restaurants.setPic3(rs.getString("pic3"));
                searchList.add(restaurants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return searchList;
    }

    @Override
    public int create(RestaurantsDTO restaurantsDTO){
        String sqlQuery ="INSERT INTO `restaurant`(`name`, `ex`, `price`, `pic1`,`pic2`,`pic3`) " +
                "VALUES (?, ?, ?,?,?,?)";
        int rows = 0;
        try{
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1,restaurantsDTO.getName());
            pstmt.setString(2,restaurantsDTO.getEx());
            pstmt.setString(3,restaurantsDTO.getPrice());
            pstmt.setString(4,restaurantsDTO.getPic1());
            pstmt.setString(5,restaurantsDTO.getPic2());
            pstmt.setString(6,restaurantsDTO.getPic3());

            rows = pstmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(RestaurantsDTO restaurantsDTO){
        String sqlQuery ="update restaurant set name=?,price=?,ex=?,pic1=?,pic2=?,pic3=? where no=?";
        int rows=0;
        try{
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(7, restaurantsDTO.getNo());
            pstmt.setString(1, restaurantsDTO.getName());
            pstmt.setString(2, restaurantsDTO.getPrice());
            pstmt.setString(3, restaurantsDTO.getEx());
            pstmt.setString(4, restaurantsDTO.getPic1());
            pstmt.setString(5, restaurantsDTO.getPic2());
            pstmt.setString(6, restaurantsDTO.getPic3());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int delete(RestaurantsDTO restaurantsDTO) {
        String sql = "delete from restaurant where no=?";
        int rows = 0; //질의 처리 결과 영향받은 행의 수
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, restaurantsDTO.getNo());
            rows = pstmt.executeUpdate();//1이상이면 정상 ,0이하면 오류
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int readTotalRows() {
        int rows = 0;
        String sqlQuery = "select count(*) as totalRows from restaurant";
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
    public List<RestaurantsDTO> readListPagination(Pagination pagination) {
        ArrayList<RestaurantsDTO> restaurantsList = null;
        String sqlQuery = "SELECT * FROM (SELECT @rownum:=@rownum+1 as rnum, A.* FROM restaurant A WHERE (@rownum:=0)=0 order by no)rd where rnum >= ? and rnum <= ?;";
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, pagination.getFirstRow());
            pstmt.setInt(2, pagination.getEndRow());
            rs = pstmt.executeQuery();
            // execute(sql)는 모든 질의에 사용가능, executeQuery(sql)는 select에만, executeUpdate()는 insert, update, delete에 사용 가능
            restaurantsList = new ArrayList<RestaurantsDTO>();
            while (rs.next()) {
                RestaurantsDTO restaurants = new RestaurantsDTO(); // roomlist->방 리스트 저장공간
                restaurants.setNo(rs.getInt("no")); // SQL문이 room테이블 기준이므로 no로 조회
                restaurants.setName(rs.getString("name"));
                restaurants.setEx(rs.getString("ex"));
                restaurants.setPrice(rs.getString("price"));
                restaurants.setPic1(rs.getString("pic1"));
                restaurants.setPic2(rs.getString("pic2"));
                restaurants.setPic3(rs.getString("pic3"));
                restaurantsList.add(restaurants);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restaurantsList;
    }


}
