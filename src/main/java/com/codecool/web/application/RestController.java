package com.codecool.web.application;

import com.codecool.business.service.HotelService;
import com.codecool.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "hotels2")
public class RestController {

    private final HotelService hotelService;

    @Autowired
    public RestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }


    @PostMapping
    public int addNewHotel(@RequestBody Hotel hotel) {
//        Hotel hotel = new Hotel(hotel_name);
//        hotel.setCity(city);
//        hotel.setWebsite(website);

        this.hotelService.addNewHotel(hotel);
        return 1;
    }

    //@PostMapping - to test it you need commment another PostMapping for now
    public int removeHotelByName(String hotel_name) {
        this.hotelService.removeHotel(hotel_name);
        return 1;
    }

    //@PostMapping - to test it you need commment another PostMapping for now
    public int updateHotelRate(String hotel_name, int rate) {
        this.hotelService.updateHotelRate(hotel_name, rate);
        return 1;
    }

    //@PostMapping - to test it you need commment another PostMapping for now
    public int updateHotelEmail(String hotel_name, String email) {
        this.hotelService.updateHotelEmail(hotel_name, email);
        return 1;
    }

    //@PostMapping - to test it you need commment another PostMapping for now
    public int updateHotelCity(String hotel_name, String city) {
        this.hotelService.updateHotelCity(hotel_name, city);
        return 1;
    }

    //@PostMapping - to test it you need commment another PostMapping for now
    public int updateHotelAddress(String hotel_name, String address) {
        this.hotelService.updateHotelAddress(hotel_name, address);
        return 1;
    }

    //@PostMapping - to test it you need commment another PostMapping for now
    public int updateHotelWebsite(String hotel_name, String website) {
        this.hotelService.updateHotelWebsite(hotel_name, website);
        return 1;
    }
}

