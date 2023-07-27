import React, { useState } from 'react';
import './Track2.css';
const TrackExpensesRevenues = () => {
  const [expenses, setExpenses] = useState([]);
  const [revenues, setRevenues] = useState([]);
  const [title, setTitle] = useState('');
  const [amount, setAmount] = useState('');

  const addExpense = () => {
    if (title && amount) {
      const newExpense = {
        title,
        amount: parseFloat(amount),
      };
      setExpenses([...expenses, newExpense]);
      setTitle('');
      setAmount('');
    }
  };

  const addRevenue = () => {
    if (title && amount) {
      const newRevenue = {
        title,
        amount: parseFloat(amount),
      };
      setRevenues([...revenues, newRevenue]);
      setTitle('');
      setAmount('');
    }
  };

  const calculateTotal = (items) => {
    return items.reduce((total, item) => total + item.amount, 0);
  };

  return (
    <div className="track-expenses-revenues">
      <h2>Expense and Revenue Tracker</h2>
      <div className="input-section">
        <label htmlFor="title">Title:</label>
        <input
          type="text"
          id="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <label htmlFor="amount">Amount:</label>
        <input
          type="number"
          id="amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
        <button onClick={addExpense}>Add Expense</button>
        <button onClick={addRevenue}>Add Revenue</button>
      </div>
      <div className="expense-section">
        <h3>Expenses</h3>
        {expenses.map((expense, index) => (
          <div key={index} className="expense-item">
            <span>{expense.title}</span>
            <span>{expense.amount}</span>
          </div>
        ))}
        <div className="total">
          <span>Total Expenses:</span>
          <span>{calculateTotal(expenses)}</span>
        </div>
      </div>
      <div className="revenue-section">
        <h3>Revenues</h3>
        {revenues.map((revenue, index) => (
          <div key={index} className="revenue-item">
            <span>{revenue.title}</span>
            <span>{revenue.amount}</span>
          </div>
        ))}
        <div className="total">
          <span>Total Revenues:</span>
          <span>{calculateTotal(revenues)}</span>
        </div>
      </div>
    </div>
  );
};

export default TrackExpensesRevenues;