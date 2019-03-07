package com.codecool.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private int id;
    @Column(name = "beds_amount")
    private int beds_amount;
    @Column(name = "max_persons")
    private int max_persons;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;
    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean is_active;

}
