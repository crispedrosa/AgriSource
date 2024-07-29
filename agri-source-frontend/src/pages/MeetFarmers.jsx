import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from '../components/Header';
import Footer from '../components/Footer';
import styles from './MeetFarmers.module.css';
import farmerImage from '../assets/farmer.png';

function MeetFarmers() {
  const [farmers, setFarmers] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchFarmers = async () => {
      try {
        const response = await axios.get('http://localhost:8081/api/users/farmers');
        console.log('Response data:', response.data);
        
        if (typeof response.data === 'string') {
          console.error('Expected array but got string:', response.data);
          setError('Unexpected data format from server.');
          return;
        }
        
        if (Array.isArray(response.data)) {
          setFarmers(response.data);
        } else {
          console.error('Expected array but got:', typeof response.data);
          setError('Unexpected data format from server.');
        }
      } catch (error) {
        console.error('Erro ao buscar fazendeiros:', error);
        setError('Não foi possível carregar os dados dos agricultores. Por favor, tente novamente mais tarde.');
      }
    };

    fetchFarmers();
  }, []);

  return (
    <>
      <Header />
      <div className={styles.container}>
        <h1>Conheça os Agricultores</h1>
        {error ? (
          <div className={styles.error}>{error}</div>
        ) : (
          <div className={styles.farmersList}>
            {farmers.map((farmer) => (
              <div key={farmer.id} className={styles.card}>
                <img src={farmer.image || farmerImage} alt={farmer.fullName} className={styles.farmerImage} />
                <div className={styles.cardContent}>
                  <h3>{farmer.fullName}</h3>
                  <p><strong>Localização:</strong> {farmer.city}, {farmer.state}</p>
                  <p>{farmer.farmDescription}</p>
                  <ul>
                    {Array.isArray(farmer.products) ? (
                      farmer.products.map((product) => <li key={product}>{product}</li>)
                    ) : (
                      <li>Nenhum produto disponível</li>
                    )}
                  </ul>
                  <div className={styles.buttonContainer}>
                    <button className={styles.productButton}>Ver Produtos</button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
      <Footer />
    </>
  );
}

export default MeetFarmers;
