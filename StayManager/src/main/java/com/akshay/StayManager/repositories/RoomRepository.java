package com.akshay.StayManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.StayManager.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}