import React, { useContext, useState } from 'react';
import PaymentContext from '../context/PaymentContext';

const PaymentComponent = () => {
  const { addPaymentDetails } = useContext(PaymentContext);
  const [paymentData, setPaymentData] = useState({ amount: '', date: '' });

  const handleChange = (e) => {
    setPaymentData({ ...paymentData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    addPaymentDetails(paymentData);
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-sm mx-auto p-4">
      <input
        type="number"
        name="amount"
        placeholder="Amount"
        value={paymentData.amount}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <input
        type="date"
        name="date"
        placeholder="Date"
        value={paymentData.date}
        onChange={handleChange}
        className="w-full p-2 mb-4 border border-gray-300 rounded"
      />
      <button type="submit" className="w-full bg-blue-500 text-white p-2 rounded">
        Add Payment
      </button>
    </form>
  );
};

export default PaymentComponent;
