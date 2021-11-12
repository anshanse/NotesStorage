-- DROP SCHEMA IF EXISTS flyway_db;
-- CREATE SCHEMA IF NOT EXISTS flyway_db;

insert into users (id, user_name, password, role)
values ('1', 'Geka', '999999', 'ROLE_ADMIN'),
       ('2', 'Ivan', '999999', 'ROLE_USER');

insert into notes(id, name, uuid, message, access_type)
values ('1', 'work', '999999', 'go work', 'PRIVATE'),
       ('2', 'work2', '122222', 'go work2', 'PUBLIC');

insert into notes (id, name, uuid, message, access_type)
values ('3', 'home', '666666', 'go for the walk', 'PUBLIC'),
       ('4', 'home2', '666666', 'call parents', 'PRIVATE');

insert into users (id, user_name, password, role)
values ('5', 'Ira', '111111', 'ROLE_ADMIN'),
       ('6', 'Bill', '111111', 'ROLE_USER');



