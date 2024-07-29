CREATE TABLE promotions (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            code VARCHAR(255) NOT NULL,
                            discount DECIMAL(10, 2) NOT NULL,
                            start_date TIMESTAMP NOT NULL,
                            end_date TIMESTAMP NOT NULL,
                            description VARCHAR(255)
);
