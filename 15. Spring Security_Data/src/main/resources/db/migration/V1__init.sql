CREATE TABLE products (id serial, title varchar(100), price numeric(6, 2));

INSERT INTO products (title, price)
VALUES
('Product #1', 10),
('Product #2', 20),
('Product #3', 30),
('Product #4', 40),
('Product #5', 50),
('Product #6', 60),
('Product #7', 100),
('Product #8', 30),
('Product #9', 40),
('Product #10', 90),
('Product #11', 120),
('Product #12', 300);

CREATE TABLE items (id serial, title varchar(100), cost int);
 INSERT INTO items (title, cost) VALUES ('Box', 10), ('Tree', 40), ('House', 90);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO users
VALUES
('user1', '{noop}123', true),
('user2', '{noop}123', true);

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    CONSTRAINT authorities_idx UNIQUE (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
);

INSERT INTO authorities
VALUES
('user1', 'ROLE_ADMIN'),
('user1', 'ROLE_USER'),
('user2', 'ROLE_USER');