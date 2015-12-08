create table person
(
person_id int primary key auto_increment,
first_name varchar(50),
user_name varchar(50) unique,
password varchar(50),
role_name varchar(10),
last_name varchar(50),
user_city varchar(50),
user_gender varchar(50),
user_state varchar(50),
user_age int,
user_email varchar(50)
);

create table groups
(  group_id int primary key auto_increment,
 group_name varchar(50),
 group_descr varchar(500),
 activated_flag boolean default true);

create table post
(
id int primary key auto_increment,
group_id int,
post varchar(2000),
person_id int,
foreign key(person_id) references person(person_id) on update cascade on delete cascade,
foreign key(group_id) references groups(group_id) on update cascade on delete cascade
);


create table comment
(
id int primary key auto_increment,
p_id int,
person_id int,
comment varchar(2000),
foreign key(p_id) references post(id) on update cascade on delete cascade,
foreign key(person_id) references person(person_id) on update cascade on delete cascade
);

create table group_person
(
group_id int,
person_id int,
flag varchar(20),
foreign key(group_id) references groups(group_id) on update cascade on delete cascade,
foreign key(person_id) references person(person_id) on update cascade on delete cascade,
primary key (group_id, person_id)
);


create table group_admins
(
group_id int,
person_id int,
foreign key(group_id) references groups(group_id) on update cascade on delete cascade,
foreign key(person_id) references person(person_id) on update cascade on delete cascade,
primary key (group_id, person_id)
);

create table like_post_person
(
post_id int,
person_id int,
foreign key(post_id) references post(id) on update cascade on delete cascade,
foreign key(person_id) references person(person_id) on update cascade on delete cascade,
primary key (post_id, person_id)
);

alter table post add likes int default 0;

alter table post add endorse boolean default false;

