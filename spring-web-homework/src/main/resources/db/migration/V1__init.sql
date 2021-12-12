create table if not exists products (id bigserial primary key, title varchar(255), price int, number int, real_value int);

insert into products (title, price, number, real_value)
values
('Bread', 42.45, 1, 0),
('Milk', 62.55, 1, 0),
('Butter', 142.35, 1, 0),
('Fish', 890.00, 1, 0),
('Pasta', 75.22, 1, 0),
('Chicken', 240.13, 1, 0),
('Rice', 70.14, 1, 0),
('Tomato', 220.75, 1, 0),
('Apple', 160.99, 1, 0),
('Orange', 220.11, 1, 0),
('Bread 0.5', 32.45, 1, 0),
('Milk 0.5', 42.55, 1, 0),
('Butter 0.5', 142.35, 1, 0),
('Fish 0.5', 750.00, 1, 0),
('Pasta 0.5', 55.22, 1, 0),
('Chicken 0.5', 210.13, 1, 0),
('Rice 0.5', 59.14, 1, 0),
('Tomato 0.5', 170.75, 1, 0),
('Apple 0.5', 99.99, 1, 0),
('Orange 0.5', 170.11, 1, 0);