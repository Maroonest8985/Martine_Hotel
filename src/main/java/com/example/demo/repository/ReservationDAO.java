package com.example.demo.repository;
import com.example.demo.Pagination;
import com.example.demo.model.ReservationDTO;
import com.example.demo.model.RestaurantsDTO;

import java.util.ArrayList;
import java.util.List;

public interface ReservationDAO {
    int insertReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> reservationList();
    ReservationDTO readReservationList(int no);
    ArrayList<ReservationDTO> readReservationListAsName(String name, String tel);
    List<ReservationDTO> readReservationListAsMemberNo(String member_no);
    int update(ReservationDTO reservationDTO);
    int delete(ReservationDTO reservationDTO);
    int readTotalRows();
    List<ReservationDTO> readListPagination(Pagination pagination);
}
