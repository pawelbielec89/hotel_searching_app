package com.codecool.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
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
}
