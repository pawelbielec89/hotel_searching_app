package com.codecool.business.service;

import com.codecool.entity.Hotel;
import com.codecool.entity.Room;
import com.codecool.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room getRoomByID(int roomID) {
        return this.roomRepository.findById(roomID).get();
    }

    public List<Room> getRoomsByHotel(Hotel hotel) {
        return this.roomRepository.findByHotel(hotel);
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


    public boolean addNewRoom(Room room) {
        roomRepository.save(room);
        return true;
    }

    public boolean removeRoom(int roomID) {
        roomRepository.delete(getRoomByID(roomID));
        return true;
    }

    public boolean updateRoomBedsAmount(int roomID, int bedsAmount) {
        Room room = getRoomByID(roomID);
        if (room == null) { return false; }

        room.setBeds_amount(bedsAmount);
        roomRepository.save(room);
        return true;
    }

    public boolean updateRoomDescription(int roomID, String description) {
        Room room = getRoomByID(roomID);
        if (room == null) { return false; }

        room.setDescription(description);
        roomRepository.save(room);
        return true;
    }

    public boolean setIsActiveToFalse(int roomID){
        Room room = getRoomByID(roomID);
        if (room == null) { return false; }

        room.setIs_active(false);
        return true;
    }

    public boolean setIsActiveToTrue(int roomID){
        Room room = getRoomByID(roomID);
        if (room == null) { return false; }

        room.setIs_active(true);
        return true;
    }
}
