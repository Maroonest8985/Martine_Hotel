package com.example.demo.repository;
import com.example.demo.Pagination;
import com.example.demo.model.MemberDTO;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.RoomsDTO;

import java.util.ArrayList;
import java.util.List;

public interface RoomsDAO {
    List<RoomsDTO> roomList();
    RoomsDTO readRoomList(int no);
    List<RoomsDTO> searchList(String date1, String date2);
    int create(RoomsDTO roomsDTO);
    int update(RoomsDTO roomsDTO);
    int delete(RoomsDTO roomsDTO);

    int readTotalRows();
    List<RoomsDTO> readListPagination(Pagination pagination);
}
