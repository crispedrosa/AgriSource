CREATE TABLE reviews (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         product_id BIGINT NOT NULL,
                         user_id BIGINT NOT NULL,
                         rating INT NOT NULL,
                         comment TEXT,
                         review_date TIMESTAMP NOT NULL
);
