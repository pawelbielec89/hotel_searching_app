package com.codecool.business.service;

import com.codecool.entity.Room;
import com.codecool.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room getRoomByID(int roomID) {
        return this.roomRepository.findById(roomID).get();
    }

    public List<Room> getRoomsByHotel(String hotelID) {
        return this.roomRepository.findByHotel(hotelID);
    }

    public List<Room> getRoomsByActiveStatus(boolean status) {
        return this.roomRepository.findByActive(status);
    }

    public List<Room> getRoomsByBedsAmount(int beds) {
        return this.roomRepository.findByBedsAmount(beds);
    }

    public List<Room> getRooms() {
        Iterable<Room> rooms = this.roomRepository.findAll();
        List<Room> roomList = new ArrayList<>();
        rooms.forEach(roomList::add);
        return roomList;
    }


    public int addNewRoom(Room room) {
        roomRepository.save(room);
        return 1;
    }

    public int removeRoom(int roomID) {
        roomRepository.delete(getRoomByID(roomID));
        return 1;
    }

    public int updateRoomBedsAmount(int roomID, int bedsAmount) {
        Room room = getRoomByID(roomID);
        if(room != null) {
            room.setBeds_amount(bedsAmount);
            roomRepository.save(room);
            return 1;
        } else {
            return 0;
        }
    }

    public int updateRoomDescription(int roomID, String description) {
        Room room = getRoomByID(roomID);
        if(room != null) {
            room.setDescription(description);
            roomRepository.save(room);
            return 1;
        } else {
            return 0;
        }
    }

    public int setIsActiveToFalse(int roomID){
        Room room = getRoomByID(roomID);
        if (room != null) {
            room.setIs_active(false);
        }
        return 1;
    }

    public int setIsActiveToTrue(int roomID){
        Room room = getRoomByID(roomID);
        if (room != null) {
            room.setIs_active(true);
        }
        return 1;
    }
}
