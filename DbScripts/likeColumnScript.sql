alter table post add likes int default 0;

alter table post add endorse boolean default false;

create table like_post_person
(
post_id int,
person_id int,
foreign key(post_id) references post(id) on update cascade on delete cascade,
foreign key(person_id) references person(person_id) on update cascade on delete cascade,
primary key (post_id, person_id)
);
