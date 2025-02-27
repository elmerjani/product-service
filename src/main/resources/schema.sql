CREATE TABLE products
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255)   NOT NULL,
    price           DECIMAL(10, 2) NOT NULL,
    available_stock INT            NOT NULL
);
