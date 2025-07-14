create table users(

    id bigint not null auto_increment,
    name varchar(32) not null,
    email varchar(64) not null,
    password varchar(64) not null,
    phone_number varchar(64) not null,
    street varchar(100) not null,
    number varchar(8) not null,
    neighborhood varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    CEP varchar(8) not null,
    complement varchar(20),
    CPF varchar(11) not null,
    user_role varchar(32) not null,
    deleted tinyint not null,

    primary key(id)

);