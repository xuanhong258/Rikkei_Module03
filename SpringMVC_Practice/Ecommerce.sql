create database Ecommerce_practice;
use Ecommerce_practice;
create table Categories
(
    catalog_id     int primary key auto_increment,
    catalog_name   varchar(100) not null unique,
    description    text,
    catalog_status bit
);

create table product(
    product_id char(4) primary key ,
    product_name varchar(100) not null unique ,
    price float check ( price > 0 ),
    title varchar(200),
    catalog_id int,
    foreign key (catalog_id) references categories(catalog_id),
    product_status bit
);

DELIMITER &&
create procedure find_all_categories()
begin
    select * from Categories;
end &&
DELIMITER &&;

DELIMITER &&
create procedure create_categories(
    cat_name_in varchar(100),
    cat_des text,
    cat_status bit
)
begin
    insert into Categories(catalog_name, description, catalog_status)
    values (cat_name_in, cat_des, cat_status);
end &&
DELIMITER &&;

DELIMITER &&
create procedure get_categories_by_id(cat_id int)
begin
    select * from Categories where catalog_id = cat_id;
end &&
DELIMITER &&;
DELIMITER &&
create procedure update_categories(
    cat_id int,
    cat_name varchar(100),
    des text,
    status_in bit
)
begin
    update categories
    set catalog_name   = cat_name,
        description    = des,
        catalog_status = status_in
    where catalog_id = cat_id;
end &&
DELIMITER &&;

DELIMITER &&
create procedure delete_categories(cat_id int)
begin
    delete from categories where catalog_id = cat_id;
end &&
DELIMITER &&;

DELIMITER &&
create procedure find_all_product()
begin
    select * from product;
end &&
DELIMITER &&;

DELIMITER &&
create procedure create_product(
    pro_id char(4),
    pro_name varchar(100),
    pro_price float,
    pro_title varchar(200),
    cat_id int,
    pro_status bit
)
begin
    insert into product(product_id, product_name, price, title, catalog_id, product_status)
    values (pro_id, pro_name, pro_price, pro_title, cat_id, pro_status);
end &&
DELIMITER &&;