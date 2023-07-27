import React, { useState } from 'react';
import axios from 'axios';
import './InvoiceBill2.css';

const InvoicePage = () => {
  const [invoiceItems, setInvoiceItems] = useState([]);
  const [newItem, setNewItem] = useState({ name: '', quantity: 0, price: 0 });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewItem((prevItem) => ({ ...prevItem, [name]: value }));
  };

  const handleAddItem = () => {
    setInvoiceItems((prevItems) => [...prevItems, newItem]);
    setNewItem({ name: '', quantity: 0, price: 0 });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8081/api/v1/auth/register", // Replace this with your backend API endpoint for user registration
        {
          name: newItem.name,
          quantity: newItem.quantity,
          price: newItem.price,
        }
      );
      console.log(response.data);
      console.log(localStorage.getItem('token'));
    } catch (error) {
      alert(error.message);
      console.log(error.message);
    }
  };

  return (
    <div className="invoice-page">
      <h1>Invoice and Billing</h1>

      <form className="invoice-form" onSubmit={handleSubmit}>
        <label>
          Item Name:
          <input
            type="text"
            name="name"
            value={newItem.name}
            onChange={handleInputChange}
          />
        </label>

        <label>
          Quantity:
          <input
            type="number"
            name="quantity"
            value={newItem.quantity}
            onChange={handleInputChange}
          />
        </label>

        <label>
          Price:
          <input
            type="number"
            name="price"
            value={newItem.price}
            onChange={handleInputChange}
          />
        </label>

        <button type="button" onClick={handleAddItem}>
          Add Item
        </button>
      </form>

      <table className="invoice-table">
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {invoiceItems.map((item, index) => (
            <tr key={index}>
              <td>{item.name}</td>
              <td>{item.quantity}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default InvoicePage;
