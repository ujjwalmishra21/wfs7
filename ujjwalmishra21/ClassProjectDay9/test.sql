Create table products(productId int primary key,productName varchar(50),category varchar(50), price int, quantity int, rol int)

INSERT INTO products(productId, productName, category, price, quantity, rol) VALUES(5,'Samsung M31S','Mobile',21500,40,5)


SELECT * FROM products;

DROP TABLE Customer;


CREATE TABLE Customer(
    customerId INT(10) PRIMARY KEY, 
    name VARCHAR(30) NOT NULL,
    gstNumber VARCHAR(20) NOT NULL UNIQUE,
    address VARCHAR(50) NOT NULL,
    city VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(10) NOT NULL UNIQUE,
    pincode VARCHAR(10) NOT NULL,
    password VARCHAR(30) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIME ON UPDATE CURRENT_TIMESTAMP
)


INSERT INTO(100000, 'Abhishek Singh',, 'L-1/33,Lodhi Road, Delhi','Delhi', )
INSERT INTO Customer VALUES