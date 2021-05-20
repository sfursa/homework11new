CREATE DATABASE addr_db;

USE addr_db;
CREATE TABLE addresses(
id INT NOT NULL,
city VARCHAR(30) NOT NULL,
street VARCHAR(255) NOT NULL,
house_number INT NOT NULL,
body VARCHAR(255),
flat INT
)