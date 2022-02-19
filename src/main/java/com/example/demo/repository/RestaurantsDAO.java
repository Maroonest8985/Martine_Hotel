package com.example.demo.repository;

import com.example.demo.Pagination;
import com.example.demo.model.MemberDTO;
import com.example.demo.model.RestaurantsDTO;
import com.example.demo.Pagination;

import java.util.List;

public interface RestaurantsDAO {
    List<RestaurantsDTO> restaurantsList();
    RestaurantsDTO readRestaurantsList(int no);
    List<RestaurantsDTO> searchList(String date1, String date2);
    int create(RestaurantsDTO restaurantsDTO);
    int update(RestaurantsDTO restaurantsDTO);
    int delete(RestaurantsDTO restaurantsDTO);
    int readTotalRows();
    List<RestaurantsDTO> readListPagination(Pagination pagination);
}
