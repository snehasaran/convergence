
INSERT INTO `hw5`.`person` (`person_id`,`first_name`,`user_name`,`password`,`role_name`,`last_name`,`user_city`,`user_gender`,`user_state`,`user_age`,`user_email`) VALUES (1,'Sneha','Saran','x','Admin','Saran','Boston','Female','MA',26,NULL);
INSERT INTO `hw5`.`person` (`person_id`,`first_name`,`user_name`,`password`,`role_name`,`last_name`,`user_city`,`user_gender`,`user_state`,`user_age`,`user_email`) VALUES (2,'Brinal','Brinal','x','GroupAdmin','Pereira','Boston','Female','MA',26,NULL);
INSERT INTO `hw5`.`person` (`person_id`,`first_name`,`user_name`,`password`,`role_name`,`last_name`,`user_city`,`user_gender`,`user_state`,`user_age`,`user_email`) VALUES (3,'Srikar','Srikar','x','User','Reddy','Boston','Male','MA',26,NULL);
INSERT INTO `hw5`.`person` (`person_id`,`first_name`,`user_name`,`password`,`role_name`,`last_name`,`user_city`,`user_gender`,`user_state`,`user_age`,`user_email`) VALUES (4,'Ramakanth','Ramakanth','x','User','Marri','Boston','Male','MA',26,NULL);
INSERT INTO `hw5`.`person` (`person_id`,`first_name`,`user_name`,`password`,`role_name`,`last_name`,`user_city`,`user_gender`,`user_state`,`user_age`,`user_email`) VALUES (5,'Mike','Mike','x','User','Korday','Boston','Male','MA',26,NULL);
INSERT INTO `hw5`.`person` (`person_id`,`first_name`,`user_name`,`password`,`role_name`,`last_name`,`user_city`,`user_gender`,`user_state`,`user_age`,`user_email`) VALUES (6,'Aniket','Aniket','x','User','Ghokde','Boston','Male','MA',27,'aniket.ghodke@gmail.com');

INSERT INTO `hw5`.`groups` (`group_name`, `group_descr`, `activated_flag`) VALUES ('Sports', 'This is a Sports group.', '1');
INSERT INTO `hw5`.`groups` (`group_name`, `group_descr`, `activated_flag`) VALUES ('Arts', 'This is an Arts group.', '1');
INSERT INTO `hw5`.`groups` (`group_name`, `group_descr`, `activated_flag`) VALUES ('Media', 'This is a Media group.', '1');
INSERT INTO `hw5`.`groups` (`group_name`, `group_descr`, `activated_flag`) VALUES ('Music', 'This is a Music group.', '1');
INSERT INTO `hw5`.`groups` (`group_name`, `group_descr`, `activated_flag`) VALUES ('Photography', 'This is a photography group.', '1');


INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('1', '1', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('2', '1', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('3', '1', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('4', '1', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('1', '2', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('2', '2', 'Pending');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('3', '2', 'Pending');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('4', '2', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('1', '3', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('2', '3', 'Pending');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('3', '3', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('4', '3', 'Pending');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('1', '4', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('2', '4', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('3', '4', 'Approved');
INSERT INTO `hw5`.`group_person` (`group_id`, `person_id`, `flag`) VALUES ('4', '4', 'Approved');


INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('1', 'Post1 On Sports', '1');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('1', 'Post2 on Sports', '2');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('1', 'Post3 on Sports', '3');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('2', 'Post1 on Arts', '2');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('2', 'Post2 on Arts', '1');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('3', 'Post1 on Media', '4');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('3', 'Post2 on Media', '4');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('3', 'Post3 on Media', '2');
INSERT INTO `hw5`.`post` (`group_id`, `post`, `person_id`) VALUES ('4', 'Post1 on Music', '1');

INSERT INTO `hw5`.`comment` (`p_id`, `person_id`, `comment`) VALUES ('1', '2', 'Comment 1 on post1 on sports');
INSERT INTO `hw5`.`comment` (`p_id`, `person_id`, `comment`) VALUES ('1', '4', 'Comment1 on sports post 1');
INSERT INTO `hw5`.`comment` (`p_id`, `person_id`, `comment`) VALUES ('2', '1', 'Comment 1 on sports post 2');
INSERT INTO `hw5`.`comment` (`p_id`, `person_id`, `comment`) VALUES ('2', '3', 'Comment 2 on post2 on sports');
INSERT INTO `hw5`.`comment` (`p_id`, `person_id`, `comment`) VALUES ('3', '1', 'Comment on post 3 on sports');

INSERT INTO `hw5`.`group_admins` (`group_id`,`person_id`) VALUES (2,2);

commit;
