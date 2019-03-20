package com.codecool.repository;

import com.codecool.entity.Hotel;
import com.codecool.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

    default List<Room> findByBedsAmount(Integer beds_amount){
        List<Room> result = new ArrayList<>();
        for (Room room : this.findAll()) {
            if (room.getBeds_amount() == beds_amount) {
                result.add(room);
            }
        }
        return result;
    }

    default List<Room> findByHotel(Hotel hotel){

        List<Room> result = new ArrayList<>();
        for (Room room : this.findAll()) {
            if (room.getHotel().equals(hotel)) {
                result.add(room);
            }
        }
        return result;
    }

    default List<Room> findByActive(Boolean is_active){

        List<Room> result = new ArrayList<>();
        for (Room room : this.findAll()) {
            if (room.getIs_active() == is_active) {
                result.add(room);
            }
        }
        return result;
    }
}


