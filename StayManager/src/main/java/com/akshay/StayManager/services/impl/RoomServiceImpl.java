package com.akshay.StayManager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.StayManager.entity.Room;
import com.akshay.StayManager.repositories.RoomRepository;
import com.akshay.StayManager.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        Room existingRoom = findById(id);
        if (existingRoom != null) {
            existingRoom.setRoomNumber(room.getRoomNumber());
            existingRoom.setType(room.getType());
            existingRoom.setStatus(room.getStatus());
            existingRoom.setPrice(room.getPrice());
            return roomRepository.save(existingRoom);
        }
        return null;
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
