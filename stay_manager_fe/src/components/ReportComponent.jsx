import React, { useContext, useEffect } from 'react';
import ReportContext from '../context/ReportContext';

const ReportComponent = () => {
  const { reports } = useContext(ReportContext);

  useEffect(() => {
    // Fetch reports when the component is mounted
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4">Reports</h2>
      <ul>
        {reports.map((report) => (
          <li key={report.id} className="mb-4 p-4 border border-gray-300 rounded">
            <h3 className="text-xl font-semibold">{report.title}</h3>
            <p>{report.content}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ReportComponent;
