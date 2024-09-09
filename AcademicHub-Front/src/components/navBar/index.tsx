import React from 'react';
import { Link } from 'react-router-dom';
import './style.css';  // Criaremos o arquivo de estilo depois
import { FaHome, FaUser, FaCog, FaChartBar, FaBell, FaCommentDots } from 'react-icons/fa';  // Usaremos esses ícones

function Navbar() {
  return (
    <nav className="navbar">
      <div className="navbar-logo">
        <span className="logo-name">AcademicHub</span>
      </div>
      <ul className="navbar-links">
        <li>
          <Link to="/home" className="nav-link">
            <FaHome />
          </Link>
        </li>
        <li>
          <Link to="/home" className="nav-link">
            <FaBell />
          </Link>
        </li>
        <li>
          <Link to="/home" className="nav-link">
            <FaUser />
          </Link>
        </li>
        <li>
          <Link to="/home" className="nav-link">
          <FaCommentDots />
          </Link>
        </li>
      </ul>
      <div className="navbar-icons">
        Eduardo Linhares
      </div>
    </nav>
  );
};

export default Navbar;
