package com.codecool.web.application;

import com.codecool.business.service.HotelService;
import com.codecool.entity.Hotel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "hotels2")
@RestController
public class AppRestController {

    private final HotelService hotelService;

    @Autowired
    public AppRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping(path = "{hotel_name}")
    public Hotel getHotelByName(@PathVariable("hotel_name") String hotel_name){
         return hotelService.getHotelByName(hotel_name);
    }

    @GetMapping(path = "id/{id}")
    public Hotel getHotelById(@PathVariable("id") Integer id) {
        return hotelService.getHotelById(id).get();
    }


    @PostMapping
    public int addNewHotel(@RequestBody Hotel hotel) {
        return this.hotelService.addNewHotel(hotel);

    }

    @DeleteMapping(path = "delete/{hotel_name}")
    public int archiveHotelByName(@PathVariable("hotel_name") String hotel_name) {
        return this.hotelService.setIsActiveToFalse(hotel_name);
    }

    @PostMapping(path = "rate")
    public int updateHotelRate(@JsonProperty String hotel_name, @JsonProperty Integer rate) {
        return this.hotelService.updateHotelRate(hotel_name, rate);
    }

    @PostMapping(path = "email")
    public int updateHotelEmail(@JsonProperty String hotel_name, @JsonProperty String email) {
        return this.hotelService.updateHotelEmail(hotel_name, email);
    }

    @PostMapping(path = "city")
    public int updateHotelCity(@JsonProperty String hotel_name, @JsonProperty String city) {
        return this.hotelService.updateHotelCity(hotel_name, city);
    }

    @PostMapping(path = "adress")
    public int updateHotelAddress(@JsonProperty String hotel_name, @JsonProperty String address) {
        return this.hotelService.updateHotelAddress(hotel_name, address);
    }

    @PostMapping(path = "website")
    public int updateHotelWebsite(@JsonProperty String hotel_name, @JsonProperty String website) {
        return this.hotelService.updateHotelWebsite(hotel_name, website);
    }
}

