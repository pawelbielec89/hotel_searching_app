package com.codecool.repository;

import com.codecool.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

//    List<Hotel> findByStars(Integer stars);
//    List<Hotel> findByCity(String city);
    //Hotel removeHotelByName(String hotel_name);
}
