create table categories
(
    id                  bigserial primary key,
    title               varchar(255) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
    );

    insert into categories (title)
    values ('Vegetables'),
           ('Fruit'),
           ('Milk products'),
           ('Bakery products'),
           ('Meat and meat products');

create table products
(
    id              bigserial primary key,
    title           varchar(255),
    price           int,
    category_id     bigint not null references categories (id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

insert into products (title, price, category_id)
values ('Milk 2,5%', 60, 3),
       ('Bread Tambov', 40, 4),
       ('Cheese Russian', 480, 3),
       ('Meat beef', 390, 5),
       ('Pork meat', 360, 5),
       ('Apple', 190, 2),
       ('Orange', 160, 2),
       ('Tomato', 225, 1),
       ('Doctors sausage', 280, 5),
       ('Metropolitan bun', 50, 4),
       ('Milk 3,2%', 66, 3),
       ('Mutton', 480, 5);

create table users
(
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table users_roles
(
    user_id    bigint not null references users (id),
    role_id    bigint not null references roles (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

create table orders
(
    id          bigserial primary key,
    user_id     bigint not null references users (id),
    total_price int    not null,
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
    price_per_product int    not null,
    price             int    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into orders (user_id, total_price, address, phone)
values (1, 200, 'address', '12345');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);

--create table categories
--(
--    id                  bigserial primary key,
--    title               varchar(50) not null,
--    created_at          timestamp default current_timestamp,
--    updated_at          timestamp default current_timestamp
--    );

--create table products_categories
--(
--    product_id bigint not null references products (id),
--    category_id bigint not null references categories (id),
--    primary key (product_id, category_id)
--    );



--insert into products_categories (product_id, category_id)
--values  (1, 3),
--        (2, 4),
--        (3, 3),
--        (4, 5),
--        (5, 5),
--        (6, 2),
--        (7, 2),
--        (8, 1),
--        (9, 5),
--        (10, 4),
--        (11, 3),
--        (12, 5);
