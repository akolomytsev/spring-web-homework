create table if not exists products (id bigserial primary key, title varchar(255), price double(2), number int);

insert into products (title, price, number)
values
('Bread', 42.45, 10),
('Milk', 62.55, 11),
('Butter', 142.35, 12),
('Fish', 890.00, 13),
('Pasta', 75.22, 14),
('Chicken', 240.13, 15),
('Rice', 70.14, 19),
('Tomato', 220.75, 16),
('Apple', 160.99, 17),
('Orange', 220.11, 18);