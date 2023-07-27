import logo from './logo.svg';
import './App.css';
import Login from './Components/Login';
import Signin from './Components/Signin';
import Navbar from './Components/Navbar';
import Sidebar from './Components/Sidebar';
import { BrowserRouter } from 'react-router-dom';
import { Route,Routes } from 'react-router-dom';
import HomePage from './Components/Homepage';
import Invoice from './Components/InvoiceBill';
import FinancialReportPage from './Components/Finantial';
import TaxCalculator from './Components/PayRoll';
import TrackExpensesRevenues from './Components/Track';
function App() {
  return (
    <div className="App">
       <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login/>} />
        <Route path="/Signin" element={<Signin />} />
       <Route path="/Navbar" element={<Navbar />} />
       <Route path="/sidebar" element={<Sidebar />} />
       <Route path="/Homepage" element={<HomePage />} />
       <Route path="/invoice" element={<Invoice />} />
       <Route path='/finantial' element={< FinancialReportPage />} />
       <Route path='/Payroll' element={< TaxCalculator />} />
       <Route path='/Track' element={< TrackExpensesRevenues />} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
