import axiosInstance from './axiosConfig';

export const getRooms = async () => {
  const response = await axiosInstance.get('/rooms');
  return response.data;
};

export const getRoomById = async (id) => {
  const response = await axiosInstance.get(`/rooms/${id}`);
  return response.data;
};

export const updateRoom = async (id, roomData) => {
  const response = await axiosInstance.put(`/rooms/${id}`, roomData);
  return response.data;
};
