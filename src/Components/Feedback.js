import React, { useState } from 'react';
import './Feedback2.css';
import { Navigate, useNavigate } from 'react-router-dom';

const FeedbackForm = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [feedback, setFeedback] = useState('');

  const navigate=useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    // Process the form data here or send it to a backend server.
    // For this example, we'll just log the data to the console.
    console.log({ name, email, feedback });
    // Reset the form after submission\
    setName('');
    setEmail('');
    setFeedback('');
  };

  return (
    <form className="feedback-form" onSubmit={handleSubmit}>
      <label htmlFor="name">Name:</label>
      <input
        type="text"
        id="name"
        value={name}
        onChange={(e) => setName(e.target.value)}
        required
      />

      <label htmlFor="email">Email:</label>
      <input
        type="email"
        id="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        required
      />

      <label htmlFor="feedback">Feedback:</label>
      <textarea
        id="feedback"
        value={feedback}
        onChange={(e) => setFeedback(e.target.value)}
        required
      ></textarea>

      <button type="submit">Submit Feedback</button>
    </form>
  );
};

export default FeedbackForm;
