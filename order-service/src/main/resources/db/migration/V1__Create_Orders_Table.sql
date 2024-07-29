CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT NOT NULL,
                        user_id BIGINT NOT NULL,
                        total_price DECIMAL(38, 2) NOT NULL,
                        order_date TIMESTAMP NOT NULL,
                        PRIMARY KEY (id)
);
