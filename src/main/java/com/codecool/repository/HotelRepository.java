package com.codecool.repository;

import com.codecool.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

 List<Hotel> findByRate(Integer rate);

 List<Hotel> findByCity(String city);

 default Hotel findHotelByName(String hotel_name) {

  for (Hotel hotel : this.findAll()) {
   if (hotel.getName().contains(hotel_name)) {
    return hotel;
   }
  }
  return null;
 }
}


