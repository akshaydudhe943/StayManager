import React, { useContext, useState, useEffect } from 'react';
import AuthContext from '../context/AuthContext';
import axiosInstance from '../api/axiosConfig';

const ProfileComponent = () => {
  const { user } = useContext(AuthContext);
  const [profileData, setProfileData] = useState({ name: '', email: '', contactDetails: '' });

  useEffect(() => {
    if (user) {
      setProfileData({ name: user.name, email: user.email, contactDetails: user.contactDetails });
    }
  }, [user]);

  const handleChange = (e) => {
    setProfileData({ ...profileData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axiosInstance.put(`/users/${user.id}`, profileData);
      console.log('Profile updated:', response.data);
    } catch (error) {
      console.error('Error updating profile:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-sm mx-auto p-4">
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={profileData.name}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={profileData.email}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <input
        type="text"
        name="contactDetails"
        placeholder="Contact Details"
        value={profileData.contactDetails}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <button type="submit" className="w-full bg-blue-500 text-white p-2 rounded">
        Update Profile
      </button>
    </form>
  );
};

export default ProfileComponent;
