
create type access_type AS ENUM ('PRIVATE', 'PUBLIC');

create type role AS ENUM ('ROLE_ADMIN', 'ROLE_USER');

create table users
(
    id        bigint not null
        constraint users_id primary key,
    password  varchar(255),
    role      varchar,
    user_name varchar(255)
);

insert into users(id, user_name,password,role)
values  (1, 'Geka','999999','ROLE_ADMIN'),(2,'Ivan','999999', 'ROLE_USER');

create table notes
(
    id          bigint not null
        constraint notes_id primary key,
    access_type varchar,
    message     varchar(255),
    name        varchar(255),
    uuid        varchar(255)
);

insert into notes(id, name,uuid,message,access_type)
values  (1, 'work','999999','go work','PRIVATE'),(2, 'work2','122222','go work2','PUBLIC');


