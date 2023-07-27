import React, { useState } from 'react';
import './verification.css';
import HomePage from './Homepage';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const Signin = () => {
  const navigate=useNavigate();
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
        try{
        const response=await axios.post(
          "http://localhost:8081/api/v1/auth/register",
          {
            name:name,
            email:email,
            password:password
          }
        ).then((response)=>{
          console.log(response.data);
          console.log(localStorage.getItem('token'));
        });
        navigate("/");}
        catch(error){
            alert(error.message);
            console.log(error.message);
        }
  };

  

  return (
    <div className="container d-flex justify-content-center">
    <div className="card">
      <form onSubmit={handleSubmit}>
        <div className="mb-3"><h2>Sign Up</h2>
          <label htmlFor="signupName" className="form-label">Name:</label>
          <input type="text" className="form-control" id="signupName" value={name} onChange={handleNameChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="signupEmail" className="form-label">Email:</label>
          <input type="email" className="form-control" id="signupEmail" value={email} onChange={handleEmailChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="signupPassword" className="form-label">Password:</label>
          <input type="password" className="form-control" id="signupPassword" value={password} onChange={handlePasswordChange} required />
        </div>
           <button type="submit" className="btn btn-primary">Sign Up</button>
      </form>
      </div>
    </div>
  );
};

export default Signin;
