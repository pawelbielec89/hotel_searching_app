package com.codecool.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@org.hibernate.annotations.DynamicInsert
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)

    @Column(columnDefinition = "serial")
    private Integer id;
    @Column(name = "hotel_name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "adress")
    private String adress;
    @Column(name = "email")
    private String email;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "website")
    private String website;

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean is_active;

    @OneToMany(mappedBy = "hotel",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    @Autowired(required = false)
    public Hotel(@JsonProperty("hotel_name") String name, @JsonProperty("city") String city,
          @JsonProperty("adress") String adress, @JsonProperty("email") String email,
          @JsonProperty("website") String website, @JsonProperty("rate") int rate) {
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.email = email;
        this.website = website;
        this.rate = rate;

    }

    public Hotel() {}
//
//    @Autowired(required = false)
//    public Hotel(@JsonProperty("hotel_name") String name) {
//        this.name = name;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }


}
