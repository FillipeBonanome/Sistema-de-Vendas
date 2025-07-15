create table restaurants(
    id bigint not null auto_increment,
    name varchar(32) not null,
    description TEXT not null,
    street varchar(100) not null,
    number varchar(8) not null,
    neighborhood varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    CEP varchar(8) not null,
    complement varchar(20),
    phone_number varchar(32) not null,
    cnpj varchar(14) not null,
    delivery_fee decimal(10, 2) not null,
    delivery_time int not null,
    primary key(id)
);