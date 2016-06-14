create table post(
id int not null auto_increment primary key,
userid int unsigned ,
title varchar(255) not null ,
content text,
create_time datetime not null default '0000-00-00 00:00:00',
foreign key (userid) references user (id)
);