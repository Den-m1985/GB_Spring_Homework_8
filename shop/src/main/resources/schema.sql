-- Создание таблицы для сущности Account
CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL
);

-- Создание таблицы для сущности Product
CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price INT NOT NULL
);


-- Добавление аккаунтов
INSERT INTO accounts (name, amount) VALUES ('John Doe', 1000.00);
INSERT INTO accounts (name, amount) VALUES ('Alice Smith', 2500.50);
INSERT INTO accounts (name, amount) VALUES ('Bob Johnson', 1500.75);

-- Добавление товаров
INSERT INTO products (name, quantity, price) VALUES ('Laptop', 10, 1200);
INSERT INTO products (name, quantity, price) VALUES ('Smartphone', 20, 800);
INSERT INTO products (name, quantity, price) VALUES ('Tablet', 15, 500);
