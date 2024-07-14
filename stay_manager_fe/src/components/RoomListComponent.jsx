import React, { useContext, useEffect } from 'react';
import RoomContext from '../context/RoomContext';

const RoomListComponent = () => {
  const { rooms, getRoomDetails } = useContext(RoomContext);

  useEffect(() => {
    getRoomDetails();
  }, [getRoomDetails]);

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4">Rooms</h2>
      <ul>
        {rooms.map((room) => (
          <li key={room.id} className="mb-4 p-4 border border-gray-300 rounded">
            <h3 className="text-xl font-semibold">{room.name}</h3>
            <p>{room.description}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default RoomListComponent;
