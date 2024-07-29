import React from 'react';
import { Link } from 'react-router-dom';
import styles from './Header.module.css';
import logo from '../assets/AgroSourceLogo.png';

function Header() {
  return (
    <header className={styles.header}>
      <div className={styles.logoContainer}>
        <Link to="/">
          <img src={logo} alt="Logo" className={styles.logo} />
        </Link>
      </div>
      <nav className={styles.nav}>
        <ul className={styles.navList}>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/Meet">Conheça os Agricultores</Link></li>
          <li><Link to="/products">Produtos</Link></li>
          <li><Link to="/login">Login</Link></li>
          <li><Link to="/cadastro">Cadastro</Link></li> 
        </ul>
      </nav>
    </header>
  );
}

export default Header;
