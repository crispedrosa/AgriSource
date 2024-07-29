CREATE TABLE Product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         price DECIMAL(10, 2) NOT NULL,
                         farmer_id BIGINT NOT NULL,
                         CONSTRAINT fk_product_user FOREIGN KEY (farmer_id) REFERENCES User(id)
);
