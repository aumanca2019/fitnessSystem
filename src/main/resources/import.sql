-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile

--@Column(name = "account_non_expired",nullable = false)
--     private boolean accountNonExpired;
--
--     @Column(name = "account_non_locked",nullable = false)
--     private boolean accountNonLocked;
--
--     @Column(name = "credentials_non_expired",nullable = false)
--     private boolean credentialsNonExpired;

--Insert Role

insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_TRAINER');
insert into role (name) values ('ROLE_ADMIN');

--Insert two users

insert into user (username,password,enabled,account_non_expired,account_non_locked,credentials_non_expired,role_id, name) values ('username', 'password',true ,true ,true ,true , 1, 'Popa Alexandru');
insert into user (username,password,enabled,account_non_expired,account_non_locked,credentials_non_expired,role_id, name) values ('username2', 'password',true ,true ,true ,true , 1 , 'Teodor Alexandru');
insert into user (username,password,enabled,account_non_expired,account_non_locked,credentials_non_expired,role_id, name) values ('trainer1','password',true ,true ,true ,true , 2, 'Teodor Tatu');
insert into user (username,password,enabled,account_non_expired,account_non_locked,credentials_non_expired,role_id, name) values ('administrator', 'password',true ,true ,true ,true , 3, 'Nea Gigel');

--Insert Tasks
insert into task (complete,description) values (true,'Code task entity');
insert into task (complete,description) values (false,'Discuss users and roles');
insert into task (complete,description) values (false ,'Enable Spring Security');
insert into task (complete,description) values (false ,'Test application');

--Insert Events

insert into event (name, description, takes_place, duration, trainer_id) values ('salsa','Lorem ipsum', '2008-11-11', 2.5, 1);
insert into event (name, description, takes_place, duration, trainer_id) values ('salsa','Lorem ipsum', '2008-11-11', 2.5, 1);
insert into event (name, description, takes_place, duration, trainer_id) values ('salsa','Lorem ipsum', '2008-11-11', 2.5, 1);
insert into event (name, description, takes_place, duration, trainer_id) values ('salsa','Lorem ipsum', '2008-11-11', 2.5, 1);
insert into event (name, description, takes_place, duration, trainer_id) values ('salsa','Lorem ipsum', '2008-11-11', 2.5, 1);
insert into event (name, description, takes_place, duration, trainer_id) values ('salsa','Lorem ipsum', '2008-11-11', 2.5, 1);


