import React, { useContext, useState, useEffect } from 'react';
import RoomContext from '../context/RoomContext';
import { useParams } from 'react-router-dom';

const RoomDetailComponent = () => {
  const { id } = useParams();
  const { selectedRoom, getRoomDetails, updateRoomDetails } = useContext(RoomContext);
  const [roomData, setRoomData] = useState({ name: '', description: '' });

  useEffect(() => {
    if (id) {
      getRoomDetails(id);
    }
  }, [id, getRoomDetails]);

  useEffect(() => {
    if (selectedRoom) {
      setRoomData({ name: selectedRoom.name, description: selectedRoom.description });
    }
  }, [selectedRoom]);

  const handleChange = (e) => {
    setRoomData({ ...roomData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    updateRoomDetails(id, roomData);
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-sm mx-auto p-4">
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={roomData.name}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <input
        type="text"
        name="description"
        placeholder="Description"
        value={roomData.description}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <button type="submit" className="w-full bg-blue-500 text-white p-2 rounded">
        Update Room
      </button>
    </form>
  );
};

export default RoomDetailComponent;
