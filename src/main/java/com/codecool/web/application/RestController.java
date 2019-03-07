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



    public int addNewHotel(String hotel_name, String city, String website) {
        Hotel hotel = new Hotel(hotel_name);
        hotel.setCity(city);
        hotel.setWebsite(website);

        this.hotelService.addNewHotel(hotel);
        return 1;
    }

    public int removeHotelByName(String hotel_name) {
        this.hotelService.removeHotel(hotel_name);
        return 1;
    }

    @PostMapping
    public int updateHotelRate(String hotel_name, int rate) {
        this.hotelService.updateHotelRate(hotel_name, rate);
        return 1;
    }
}

