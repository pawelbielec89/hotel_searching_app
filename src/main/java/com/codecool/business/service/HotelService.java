package com.codecool.business.service;

import com.codecool.business.domain.HotelResearch;
import com.codecool.entity.Hotel;
import com.codecool.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotelsByName(String hotelName) {
        Iterable<Hotel> hotels = this.hotelRepository.findAll();
        List<Hotel> hotelList = new ArrayList<>();

        hotels.forEach(hotel->{
            if(hotel.getName().contains(hotelName)) {
                hotelList.add(hotel);
            }
        });
        return hotelList;
    }
}
