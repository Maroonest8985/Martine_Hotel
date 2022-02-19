package com.example.demo.repository;

import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.ReservationDTO;
import com.example.demo.model.RoomsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChartDAOImpl extends DAOImplMysql implements ChartDAO{

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<ReservationDTO> chartList() {
        String sqlQuery = "SELECT * FROM reservaiton_room";
        ArrayList<ReservationDTO> roomchartList = null;
        try {
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            roomchartList = new ArrayList<ReservationDTO>();
            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO(); // roomlist->방 리스트 저장공간
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roomchartList;
    }

}
