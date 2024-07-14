import React, { createContext, useState, useEffect } from 'react';
import { getPayments, addPayment } from '../api/paymentService';

const PaymentContext = createContext();

export const PaymentProvider = ({ children }) => {
  const [payments, setPayments] = useState([]);

  useEffect(() => {
    const fetchPayments = async () => {
      const data = await getPayments();
      setPayments(data);
    };
    fetchPayments();
  }, []);

  const addPaymentDetails = async (paymentData) => {
    const data = await addPayment(paymentData);
    setPayments((prevPayments) => [...prevPayments, data]);
  };

  return (
    <PaymentContext.Provider value={{ payments, addPaymentDetails }}>
      {children}
    </PaymentContext.Provider>
  );
};

export default PaymentContext;
