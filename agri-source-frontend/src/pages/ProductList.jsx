import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from './ProductList.module.css';

function ProductList() {
    const [products, setProducts] = useState([]);
  
    useEffect(() => {
      axios.get('http://localhost:8080/api/products')
        .then(response => {
          setProducts(response.data);
        })
        .catch(error => {
          console.error("Erro ao buscar produtos: ", error);
        });
    }, []);
  
    return (
      <>
        <Header />
        <div className={styles.container}>
          <h1>Produtos Disponíveis</h1>
          <div className={styles.productsList}>
            {products.map((product) => (
              <div key={product.id} className={styles.card}>
                <div className={styles.cardImage}>
                  <img src={product.imageUrl || '/placeholder-image.png'} alt={product.name} />
                </div>
                <div className={styles.cardContent}>
                  <h3>{product.name}</h3>
                  <p>{product.description}</p>
                  <p><strong>Preço:</strong> ${product.price.toFixed(2)}</p>
                  <p><strong>Quantidade:</strong> {product.quantity}</p>
                  <div className={styles.buttonContainer}>
                    <button className={styles.productButton}>Comprar</button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
        <Footer />
      </>
    );
  }
  
  export default ProductList;
  