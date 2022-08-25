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
    id serial,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(80) NOT NULL,
    name VARCHAR(80) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles (
   id     serial,
   name   VARCHAR(50) DEFAULT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE users_roles (
   user_id   int NOT NULL,
   role_id   int NOT NULL,

   PRIMARY KEY (user_id, role_id),

   CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
   REFERENCES users (id)
   ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO roles (name)
VALUES
('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users (username, password, name, email)
VALUES
('admin', '$2y$10$T/r9sZhDMyak/NZKSW7RzOTAS1905WJeGzHPfgo15EFfve3fpFLWa', 'Bob Jekson',
 'bob@gmail.com');

 INSERT INTO users_roles (user_id, role_id)
 VALUES
 (1, 1),
 (1, 2);