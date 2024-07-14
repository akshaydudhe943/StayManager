import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-dom';
import { AuthProvider } from './context/AuthContext';
import { RoomProvider } from './context/RoomContext';
import { PaymentProvider } from './context/PaymentContext';
import { NotificationProvider } from './context/NotificationContext';
import { ReportProvider } from './context/ReportContext';

import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import DashboardPage from './pages/DashboardPage';
import RoomPage from './pages/RoomPage';
import PaymentPage from './pages/PaymentPage';
import NotificationPage from './pages/NotificationPage';
import ReportPage from './pages/ReportPage';

function App() {
  return (
    <AuthProvider>
      <RoomProvider>
        <PaymentProvider>
          <NotificationProvider>
            <ReportProvider>
              <Router>
                <Routes>
                  <Route path="/" element={<LoginPage />} />
                  <Route path="/register" element={<RegisterPage />} />
                  <Route path="/dashboard" element={<DashboardPage />} />
                  <Route path="/rooms" element={<RoomPage />} />
                  <Route path="/payments" element={<PaymentPage />} />
                  <Route path="/notifications" element={<NotificationPage />} />
                  <Route path="/reports" element={<ReportPage />} />
                </Routes>
              </Router>
            </ReportProvider>
          </NotificationProvider>
        </PaymentProvider>
      </RoomProvider>
    </AuthProvider>
  );
}

export default App;
