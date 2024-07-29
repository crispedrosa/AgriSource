import React from 'react';
import styles from './Footer.module.css';

function Footer() {
  return (
    <footer className={styles.footer}>
      <div className={styles.footerContent}>
        <div className={styles.footerSection}>
          <h4>Contato</h4>
          <p>Email: contato@agrisource.com</p>
          <p>Telefone: (11) 4002-8922</p>
        </div>
        <div className={styles.footerSection}>
          <h4>Empresa</h4>
          <ul>
            <li>Sobre Nós</li>
            <li>Produtos</li>
            <li>Contato</li>
          </ul>
        </div>
        <div className={styles.footerSection}>
          <h4>Redes Sociais</h4>
          <p>Siga-nos nas redes sociais:</p>
        </div>
      </div>
      <div className={styles.footerBottom}>
        <p>© 2024 AgriSource. Todos os direitos reservados.</p>
      </div>
    </footer>
  );
}

export default Footer;