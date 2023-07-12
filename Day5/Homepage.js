import React from 'react';
// import Navbar from './Navbar';
import Sidebar from './Sidebar';
import SpeedDialTooltipOpen from './SpeedDialTooltipOpen';

const HomePage = () => {
  return (
    <div className='home'>
      {/* <Navbar /> */}
      <Sidebar />
      <SpeedDialTooltipOpen />
    </div>
  );
};
export default HomePage;