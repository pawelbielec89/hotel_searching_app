package com.codecool.entity;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)

    @Column(name = "room_id", columnDefinition = "serial")
    private int id;
    @Column(name = "beds_amount")
    private int beds_amount;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;
    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean is_active;

}
