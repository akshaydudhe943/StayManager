package com.akshay.StayManager.services;

import java.util.List;

import com.akshay.StayManager.entity.Room;

public interface RoomService {
    Room addRoom(Room room);
    Room updateRoom(Long id, Room room);
    void deleteRoom(Long id);
    Room findById(Long id);
    List<Room> findAll();
}