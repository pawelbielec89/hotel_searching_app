package com.codecool.business.service;

import com.codecool.entity.Hotel;
import com.codecool.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Hotel> getHotelsByCity(String cityName) {
        Iterable<Hotel> hotels = this.hotelRepository.findAll();
        List<Hotel> hotelListInCity = new ArrayList<>();
        for (Hotel h : hotels) {
            if (h.getCity().equals(cityName))
                hotelListInCity.add(h);
        }
        return hotelListInCity;
    }

    public Optional<Hotel> getHotelById(Integer id) {
        return hotelRepository.findById(id);
    }

    public boolean addNewHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return true;
    }

    public boolean setIsActiveToFalse(String hotelName) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel == null) { return false; }

        hotel.setIs_active(false);
        hotelRepository.save(hotel);
        return true;
    }

    public boolean setIsActiveToTrue(String hotelName) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel == null) { return false; }

        hotel.setIs_active(true);
        hotelRepository.save(hotel);
        return true;
    }

    public boolean updateHotelRate(String hotelName, Integer rate) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel == null) { return false; }

        hotel.setRate(rate);
        hotelRepository.save(hotel);
        return true;
    }

    public boolean updateHotelEmail(String hotelName, String email) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel == null) { return false; }

        hotel.setEmail(email);
        hotelRepository.save(hotel);
         return true;
    }

    public boolean updateHotelCity(String hotelName, String city) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel == null) { return false; }

        hotel.setCity(city);
        hotelRepository.save(hotel);
        return true;
    }

    public boolean updateHotelAddress(String hotelName, String address) {
        Hotel hotel = getHotelByName(hotelName);
        if(hotel == null) { return false; }
            hotel.setAdress(address);
            hotelRepository.save(hotel);
            return true;
    }

    public boolean updateHotelWebsite(String hotelName, String website) {
        Hotel hotel = getHotelByName(hotelName);
        if (hotel == null) { return false; }

        hotel.setWebsite(website);
        hotelRepository.save(hotel);

        return true;
    }
}
