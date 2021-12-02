DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price numeric(6, 2), PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Bread', 42.63), ('Milk', 62.43), ('Butter', 142.36), ('Fish', 890.00), ('Pasta', 75.00), ('Chicken', 240.06), ('Rice', 70.99), ('Tomato', 220.22), ('Apple', 160.16), ('Orange', 220.99);

DROP TABLE buyers IF EXISTS;
CREATE TABLE IF NOT EXISTS buyers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO buyers (name) VALUES ('Alexander'), ('Feodosia'), ('Onufry'), ('George'), ('Afonasy');

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE IF NOT EXISTS orders (product_id bigint, buyer_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (buyer_id) REFERENCES buyers (id));
INSERT INTO orders (product_id, buyer_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 1), (7, 2), (8, 3), (9, 4), (10, 5);
