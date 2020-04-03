drop table if exists order;
create table order(
ord_id int not null auto_increment,
good_name varchar(32) not null,
good_summary varchar (32) default null ,
primary key (msg_id)
)engine=InnoDB auto_increment=1 default charset=utf8