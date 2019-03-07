package com.codecool.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "hotel_name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "adress")
    private String adress;
    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;
    @Column(name = "rate")
    private int rate;

    @OneToMany(mappedBy = "hotel",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

//    public Hotel(@JsonProperty("hotel_name") String name, @JsonProperty("city") String city,
//          @JsonProperty("adress") String adress, @JsonProperty("email") String email,
//          @JsonProperty("website") String website) {
//        this.name = name;
//        this.city = city;
//        this.adress = adress;
//        this.website = website;
//        this.email = email;
//    }

    public Hotel() {}

    @Autowired(required = false)
    public Hotel(@JsonProperty("hotel_name") String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


}
