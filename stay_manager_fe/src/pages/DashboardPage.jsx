import React from 'react';
import RoomListComponent from '../components/RoomListComponent';

const DashboardPage = () => {
  return (
    <div className="p-4">
      <h1 className="text-3xl font-bold mb-4">Dashboard</h1>
      <RoomListComponent />
    </div>
  );
};

export default DashboardPage;
