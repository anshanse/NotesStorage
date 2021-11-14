
create table notes (
	id varchar(36) not null,
	access_type varchar(7),
	message varchar(10000),
	name varchar(255),
	user_id varchar(36),
	primary key (id)
	);
create table user_role (
	user_id varchar(255) not null,
	roles varchar(255)
	);
create table users (
	id varchar(36) not null,
	active boolean not null,
	password varchar(255) not null,
	username varchar(50) not null,
	primary key (id)
	);
alter table if exists notes 
	add constraint FKechaouoa6kus6k1dpix1u91c 
	foreign key (user_id) references users;
alter table if exists user_role 
	add constraint FKj345gk1bovqvfame88rcx7yyx 
	foreign key (user_id) references users;