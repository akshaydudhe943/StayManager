import React, { createContext, useState, useEffect } from 'react';
import { login, register } from '../api/authService';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      // Decode token to get user info
      // setUser(decodedUser);
    }
  }, []);

  const loginHandler = async (credentials) => {
    const data = await login(credentials);
    localStorage.setItem('token', data.token);
    setUser(data.user);
  };

  const registerHandler = async (userData) => {
    const data = await register(userData);
    localStorage.setItem('token', data.token);
    setUser(data.user);
  };

  return (
    <AuthContext.Provider value={{ user, loginHandler, registerHandler }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
