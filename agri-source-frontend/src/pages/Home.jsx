import React from 'react';
import { Link } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from './Home.module.css';

const Home = () => {
  return (
    <>
      <Header />
      <div className={styles.home}>
        <h1>Bem-vindo ao AgriSource!</h1>
        <p>Explore nossos produtos frescos e sustentáveis diretamente dos agricultores familiares.</p>
        <Link to="/produtos" style={{ textDecoration: 'none' }}>
          <button className={styles.exploreButton}>Explore Agora</button>
        </Link>

        <div className={styles.bannerSection}>
          <div className={styles.bannerCard}>
            <img src="src/assets/produtores.jpeg" alt="Agricultores" />
            <h3>Agricultores Cadastrados</h3>
            <p>Conheça os agricultores que tornam possível a oferta de produtos frescos todos os dias.</p>
            <Link to="/Meet" style={{ textDecoration: 'none' }}>
              <button>Conheça os Agricultores</button>
            </Link>
          </div>
          <div className={styles.bannerCard}>
            <img src="src/assets/produtos.jpg" alt="Produtos" />
            <h3>Produtos Disponíveis</h3>
            <p>Descubra a variedade de produtos frescos disponíveis para compra direta.</p>
            <Link to="/products" style={{ textDecoration: 'none' }}>
              <button>Explore Produtos</button>
            </Link>
          </div>
          <div className={styles.bannerCard}>
            <img src="src/assets/entregador.jpg" alt="Receitas" />
            <h3>Rastrear Entregas</h3>
            <p>Comprou com nossos fornecedores e quer saber como está a entrega do seu pedido?</p>
            <Link to="/rastreamento" style={{ textDecoration: 'none' }}>
              <button>Rastrear minha encomenda</button>
            </Link>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Home;
