package com.codecool.business.service;

import com.codecool.entity.Hotel;
import com.codecool.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel getHotelByName(String hotelName) {
        return this.hotelRepository.findHotelByName(hotelName);
    }

    public List<Hotel> getHotels() {
        Iterable<Hotel> hotels = this.hotelRepository.findAll();
        List<Hotel> hotelList = new ArrayList<>();
        hotels.forEach(hotelList::add);
        return hotelList;
    }

    public int addNewHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return 1;
    }

    public int removeHotel(String hotelName) {
        hotelRepository.delete(getHotelByName(hotelName));
        return 1;
    }

    public int updateHotelRate(String hotelName, int rate) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel != null) {
            hotel.setRate(rate);
            hotelRepository.save(hotel);
            return 1;
        } else {
            return 0;
        }
    }

    public int updateHotelEmail(String hotelName, String email) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel != null) {
            hotel.setEmail(email);
            hotelRepository.save(hotel);
            return 1;
        } else {
            return 0;
        }
    }

    public int updateHotelCity(String hotelName, String city) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel != null) {
            hotel.setCity(city);
            hotelRepository.save(hotel);
            return 1;
        } else {
            return 0;
        }
    }

}
