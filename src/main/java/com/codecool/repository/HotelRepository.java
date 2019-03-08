package com.codecool.repository;

import com.codecool.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

 default Hotel findHotelByName(String hotel_name) {
  for (Hotel hotel : this.findAll()) {
   if (hotel.getName().toLowerCase().equals(hotel_name.toLowerCase().replace('_', ' '))) {
    return hotel;
   }
  }
  return null;
 }
}


