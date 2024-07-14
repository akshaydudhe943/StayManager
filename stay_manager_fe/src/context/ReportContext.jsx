import React, { createContext, useState, useEffect } from 'react';
import { getReports } from '../api/reportService';

const ReportContext = createContext();

export const ReportProvider = ({ children }) => {
  const [reports, setReports] = useState([]);

  useEffect(() => {
    const fetchReports = async () => {
      const data = await getReports();
      setReports(data);
    };
    fetchReports();
  }, []);

  return (
    <ReportContext.Provider value={{ reports }}>
      {children}
    </ReportContext.Provider>
  );
};

export default ReportContext;
