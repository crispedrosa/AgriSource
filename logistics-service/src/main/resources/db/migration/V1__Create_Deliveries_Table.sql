CREATE TABLE deliveries (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            order_id BIGINT NOT NULL,
                            delivery_service_id BIGINT NOT NULL,
                            delivery_status VARCHAR(255) NOT NULL,
                            estimated_delivery_date TIMESTAMP NOT NULL,
                            tracking_number VARCHAR(255)
);
