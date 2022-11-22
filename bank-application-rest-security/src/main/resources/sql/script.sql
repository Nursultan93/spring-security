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

insert into users value (null,'happy', '123', 1);
insert into authorities value (null,'happy', 'write');