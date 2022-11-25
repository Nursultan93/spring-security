create database db_spring_security;

use db_spring_security;

create table users (
                       id int primary key auto_increment,
                       username varchar(10) not null,
                       password varchar(50) not null,
                       enabled int not null
);


create table authorities(
                            id int primary key auto_increment,
                            username varchar(10) not null,
                            authority varchar(10) not null
);

create table customer
(
    id       int auto_increment,
    email    varchar(50)  not null,
    password varchar(200) not null,
    role     varchar(50)  not null,
    constraint customer_pk
        primary key (id)
);

insert into users value (null,'happy', '123', 1);
insert into authorities value (null,'happy', 'write');
insert into customer value(null, 'test@gmail.com', '123', 'admin');