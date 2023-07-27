import React from 'react';
import Sidebar from './Sidebar';
import './home.css'
const HomePage = () => {
  return (
    <div className="home-page">
      <Sidebar />
      <div className="content">
        <section className="hero">
          <div className="hero-content">
            <h1>Welcome to Your Accounting Application</h1>
            <p>Streamline your accounting processes with our powerful and intuitive accounting application.</p>
            <a href="#features" className="cta-button">Learn More</a>
          </div>
        </section>

        <section id="features" className="features">
          <div className="feature">
            <div className="feature-icon">
              <i className="fas fa-file-invoice-dollar"></i>
            </div>
            <div className="feature-content">
              <h2>Efficient Invoicing & Billing</h2>
              <p>Create professional invoices, track payments, and send automatic payment reminders to clients. Easily manage your billing cycle and ensure timely payments.</p>
            </div>
          </div>

          <div className="feature">
            <div className="feature-icon">
              <i className="fas fa-chart-line"></i>
            </div>
            <div className="feature-content">
              <h2>Detailed Financial Reports</h2>
              <p>Generate comprehensive financial reports that provide a clear overview of your business's financial health. Analyze revenue, expenses, profit margins, and make informed decisions for growth.</p>
            </div>
          </div>

          <div className="feature">
            <div className="feature-icon">
              <i className="fas fa-money-check-alt"></i>
            </div>
            <div className="feature-content">
              <h2>Streamlined Payroll Management</h2>
              <p>Simplify payroll processing, calculate employee salaries, handle tax deductions, and generate accurate payslips. Ensure timely and accurate payments to your employees.</p>
            </div>
          </div>

          <div className="feature">
            <div className="feature-icon">
              <i className="fas fa-chart-pie"></i>
            </div>
            <div className="feature-content">
              <h2>Track Expenses & Revenues</h2>
              <p>Effortlessly track and categorize your business expenses and revenues. Stay on top of your financial transactions, identify trends, and make data-driven decisions for cost optimization.</p>
            </div>
          </div>

          <div className="feature">
            <div className="feature-icon">
              <i className="fas fa-lock"></i>
            </div>
            <div className="feature-content">
              <h2>Secure & Reliable</h2>
              <p>Your data is protected with advanced security measures and regular backups. Rest assured that your sensitive financial information is kept safe and accessible only to authorized users.</p>
            </div>
          </div>

          <div className="feature">
            <div className="feature-icon">
              <i className="fas fa-cogs"></i>
            </div>
            <div className="feature-content">
              <h2>Customizable Account Settings</h2>
              <p>Personalize your accounting experience with flexible account settings. Customize preferences, update contact information, and tailor the application to meet your specific needs.</p>
            </div>
          </div>
        </section>

        <section className="cta-section">
          <h2>Get Started Today</h2>
          <p>Revolutionize the way you manage your accounting processes!</p>
          <a href="#contact" className="cta-button">Contact Us</a>
        </section>

        <section id="contact" className="contact-section">
          <h2>Contact Us</h2>
          <p>For any inquiries or assistance, please feel free to reach out to our team.</p>
          <a href="mailto:info@example.com" className="contact-email">info@example.com</a>
        </section>
      </div>
    </div>
  );
}

export default HomePage;
