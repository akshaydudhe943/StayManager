import React, { createContext, useState, useEffect } from 'react';
import { getRooms, getRoomById, updateRoom } from '../api/roomService';

const RoomContext = createContext();

export const RoomProvider = ({ children }) => {
  const [rooms, setRooms] = useState([]);
  const [selectedRoom, setSelectedRoom] = useState(null);

  useEffect(() => {
    const fetchRooms = async () => {
      const data = await getRooms();
      setRooms(data);
    };
    fetchRooms();
  }, []);

  const getRoomDetails = async (id) => {
    const data = await getRoomById(id);
    setSelectedRoom(data);
  };

  const updateRoomDetails = async (id, roomData) => {
    const data = await updateRoom(id, roomData);
    setSelectedRoom(data);
  };

  return (
    <RoomContext.Provider value={{ rooms, selectedRoom, getRoomDetails, updateRoomDetails }}>
      {children}
    </RoomContext.Provider>
  );
};

export default RoomContext;
