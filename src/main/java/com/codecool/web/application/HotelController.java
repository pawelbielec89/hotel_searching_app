package com.codecool.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hotels")
public class HotelController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHotels(){
        return "hotels";
    }
}
