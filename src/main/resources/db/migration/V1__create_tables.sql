CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    ordertime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE orderitems (
    orderid INT NOT NULL,
    productid INT NOT NULL,
    quantity INT NOT NULL,
    amount DOUBLE NOT NULL,
    PRIMARY KEY (orderid),
    FOREIGN KEY (orderid) REFERENCES orders(id),
    FOREIGN KEY (productid) REFERENCES products(id)
);

CREATE TABLE payments (
    orderid INT NOT NULL,
    pay_type VARCHAR(255) NOT NULL,
    pay_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    amount DOUBLE NOT NULL,
    FOREIGN KEY (orderid) REFERENCES orders(id)
);
