drop table if exists order;
create table order(
ord_id int not null auto_increment,
good_name varchar(20) not null,
create_time datetime not null,
good_price double not null,
good_number int not null,
primary key (ord_id)
)engine=InnoDB auto_increment=1 default charset=utf8