create table products
(
    id              bigserial primary key,
    title           varchar(255),
    price           numeric(8, 2) not null,
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into products (title, price)
values ('Milk 2,5%', 60.00),
       ('Bread Tambov', 40.00),
       ('Cheese Russian', 480.00),
       ('Meat beef', 390.00),
       ('Pork meat', 360.00),
       ('Apple', 190.00),
       ('Orange', 160.00),
       ('Tomato', 225.00),
       ('Doctors sausage', 280.00),
       ('Metropolitan bun', 50.00),
       ('Milk 3,2%', 66.00),
       ('Mutton', 480.00);

create table orders
(
    id          bigserial primary key,
    username    varchar(255) not null,
    total_price numeric(8, 2)    not null,
    address     varchar(255),
    phone       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product numeric(8, 2)    not null,
    price             numeric(8, 2)    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into orders (username, total_price, address, phone)
values ('bob', 200.00, 'address', '12345');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100.00, 200.00);
