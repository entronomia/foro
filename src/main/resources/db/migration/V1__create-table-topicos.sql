create table topicos(
id bigint not null auto_increment,
usuario varchar(20) not null,
titulo varchar(50) not null,
tema varchar(20) not null,
mensaje varchar(300) not null,
fecha varchar(12) not null,
primary key(id)
);
