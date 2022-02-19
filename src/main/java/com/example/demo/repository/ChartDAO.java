package com.example.demo.repository;

import com.example.demo.model.RestaurantsDTO;
import com.example.demo.model.ReservationDTO;

import java.util.List;

public interface ChartDAO {
    List<ReservationDTO> chartList();
}
