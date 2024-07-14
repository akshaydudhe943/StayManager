import axiosInstance from './axiosConfig';

export const getPayments = async () => {
  const response = await axiosInstance.get('/payments');
  return response.data;
};

export const addPayment = async (paymentData) => {
  const response = await axiosInstance.post('/payments', paymentData);
  return response.data;
};
