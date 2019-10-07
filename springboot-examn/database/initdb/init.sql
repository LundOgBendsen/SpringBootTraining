create schema if not exists productapi collate utf8mb4_0900_ai_ci;

create user 'product'@'%' identified WITH mysql_native_password by 'my8charspassword';
grant all on *.* to 'product'@'%' with grant option;


use productapi;



create table if not exists order_line
(
    id            bigint auto_increment primary key,
    amount        int          null,
    orderline_sum double       null,
    product_name  varchar(255) null,
    product_price double       null,
    order_id      bigint       null
)
    engine = INNODB;

create index FKk9f9t1tmkbq5w27u8rrjbxxg6
    on order_line (order_id);

create table if not exists orders
(
    id         bigint auto_increment primary key,
    email      varchar(255) not null,
    created_at datetime     null,
    sum        double       null
)
    engine = INNODB;

create table if not exists product
(
    id    bigint auto_increment primary key,
    name  varchar(255) null,
    price double       null
)
    engine = INNODB;



insert into product(name, price)
values ("p1", 1.5),
       ("p2", 2.5),
       ("p3", 3.5),
       ("p4", 4.5);


insert into orders(id, email, created_at, sum)
VALUES (1, 'name@example.com', "2019-01-01", 10),
       (2, 'name2@example.com', "2019-02-01", 14);

insert into order_line(amount, orderline_sum, product_name, product_price, order_id)
VALUES (4, 10, "p1", 1.5, 1),
       (4, 14, "p3", 3.5, 2);