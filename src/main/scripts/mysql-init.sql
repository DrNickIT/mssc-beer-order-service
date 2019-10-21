DROP DATABASE IF EXISTS beerorderservice;
DROP USER IF EXISTS 'beer_order_service'@'localhost';
CREATE DATABASE IF NOT EXISTS beerorderservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'beer_order_service'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT,
    TRIGGER on beerorderservice.* TO 'beer_order_service'@'localhost';
FLUSH PRIVILEGES;