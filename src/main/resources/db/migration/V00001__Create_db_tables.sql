create type access_type AS ENUM ('PRIVATE', 'PUBLIC');

create type role AS ENUM ('ROLE_ADMIN', 'ROLE_USER');

create table users
(
    id        varchar not null
        constraint users_id primary key,
    password  varchar(255),
    role      varchar,
    user_name varchar(255)
);

create table notes
(
    id          varchar not null
        constraint notes_id primary key,
    access_type varchar,
    message     varchar(255),
    name        varchar(255),
    uuid        varchar(255)
);



