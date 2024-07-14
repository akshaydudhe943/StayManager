import React, { useContext, useEffect } from 'react';
import NotificationContext from '../context/NotificationContext';

const NotificationComponent = () => {
  const { notifications } = useContext(NotificationContext);

  useEffect(() => {
    // Fetch notifications when the component is mounted
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4">Notifications</h2>
      <ul>
        {notifications.map((notification) => (
          <li key={notification.id} className="mb-4 p-4 border border-gray-300 rounded">
            <h3 className="text-xl font-semibold">{notification.title}</h3>
            <p>{notification.message}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default NotificationComponent;
