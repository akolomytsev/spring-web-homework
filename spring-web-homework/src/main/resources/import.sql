DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), prise int, PRIMARY KEY (id));
INSERT INTO products (title, prise) VALUES ('Bread', 42), ('Milk', 62), ('Butter', 142);
