import React, { useState, useEffect, useRef } from 'react';
import Chart from 'chart.js/auto';
import './Finantial2.css'
const FinancialReportPage = () => {
  const chartRef = useRef(null);
  const chartInstance = useRef(null);

  const [financialData, setFinancialData] = useState([
    { category: 'Revenue', amount: 0 },
    { category: 'Expenses', amount: 0 },
    { category: 'Profit', amount: 0 },
  ]);

  useEffect(() => {
    const labels = financialData.map((item) => item.category);
    const amounts = financialData.map((item) => item.amount);

    const chartData = {
      labels: labels,
      datasets: [
        {
          label: 'Amount',
          data: amounts,
          backgroundColor: [
            'rgba(75, 192, 192, 0.6)',
            'rgba(255, 99, 132, 0.6)',
            'rgba(54, 162, 235, 0.6)',
          ],
          borderColor: [
            'rgba(75, 192, 192, 1)',
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
          ],
          borderWidth: 1,
        },
      ],
    };

    const chartOptions = {
      responsive: true,
      scales: {
        y: {
          beginAtZero: true,
          grid: {
            color: 'rgba(0, 0, 0, 0.1)',
          },
        },
        x: {
          grid: {
            display: false,
          },
        },
      },
    };

    if (chartInstance.current) {
      // If chart instance already exists, destroy it before creating a new one
      chartInstance.current.destroy();
    }

    chartInstance.current = new Chart(chartRef.current, {
      type: 'bar',
      data: chartData,
      options: chartOptions,
    });
  }, [financialData]);

  const handleInputChange = (index, e) => {
    const { name, value } = e.target;
    setFinancialData((prevData) => {
      const newData = [...prevData];
      newData[index] = { ...newData[index], [name]: Number(value) };
      return newData;
    });
  };

  return (
    <div className="financial-report-page">
      <h1>Financial Report</h1>

      <div className="financial-boxes">
        {financialData.map((item, index) => (
          <div className="financial-box" key={index}>
            <h3>{item.category}</h3>
            <p>{item.amount}</p>
          </div>
        ))}
      </div>

      <form className="financial-form">
        {financialData.map((item, index) => (
          <div className="form-group" key={index}>
            <label htmlFor={`amount-${index}`}>{item.category}</label>
            <input
              type="number"
              id={`amount-${index}`}
              name="amount"
              value={item.amount}
              onChange={(e) => handleInputChange(index, e)}
            />
          </div>
        ))}
        <button type="submit">Submit</button>
      </form>

      <div className="financial-chart-container">
        <canvas ref={chartRef} className="financial-chart" />
      </div>
    </div>
  );
};

export default FinancialReportPage;
