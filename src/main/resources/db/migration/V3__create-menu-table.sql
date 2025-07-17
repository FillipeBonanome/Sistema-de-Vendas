create table menus(
    id bigint not null auto_increment,
    name varchar(32) not null,
    description TEXT,
    restaurant_id bigint not null,

    primary key(id),
    constraint fk_menu_restaurant_id foreign key(restaurant_id) references restaurants(id)
);