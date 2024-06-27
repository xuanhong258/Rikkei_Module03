create database Ecommerce;
use Ecommerce;
create table Categories(
    catalog_id int primary key auto_increment,
    catalog_name varchar(100) not null unique ,
    description text,
    catalog_status bit
);

DELIMITER &&
create procedure find_all_categories()
begin
    select * from Categories;
end;
DELIMITER &&

DELIMITER &&
create  procedure  create_categories(
    cat_name_in varchar(100),
    cat_des text,
    cat_status bit
)
begin
    insert into Categories(catalog_name, description, catalog_status)
    values (cat_name_in, cat_des, cat_status);
end;
DELIMITER &&

DELIMITER &&
create procedure get_catalog_by_id(cat_id int)
begin
    select * from categories where catalog_id = cat_id;
end &&
DELIMITER &&

DELIMITER &&
create procedure update_categories(
    cat_id int,
    cat_name varchar(100),
    cat_des text,
    cat_status bit
)
begin
    update categories
        set catalog_name = cat_name,
            description = cat_des,
            catalog_status = cat_status
    where catalog_id = cat_id;
end &&
DELIMITER &&

DELIMITER &&
create procedure delete_categories(cat_id int)
begin
    delete
    from categories
    where catalog_id = cat_id;
end &&
DELIMITER &&