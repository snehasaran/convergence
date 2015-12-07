
INSERT INTO `hw5`.`person` (`person_id`, `first_name`, `user_name`, `password`, `role_name`, `last_name`, `user_city`, `user_gender`, `user_state`, `user_age`) VALUES ('1', 'Sneha', 'Saran', 'x', 'Admin', 'Saran', 'Boston', 'Female', 'MA', '26');
INSERT INTO `hw5`.`person` (`person_id`, `first_name`, `user_name`, `password`, `role_name`, `last_name`, `user_city`, `user_gender`, `user_state`, `user_age`) VALUES ('2', 'Brinal', 'Brinal', 'x', 'User', 'Pereira', 'Boston', 'Female', 'MA', '26');
INSERT INTO `hw5`.`person` (`person_id`, `first_name`, `user_name`, `password`, `role_name`, `last_name`, `user_city`, `user_gender`, `user_state`, `user_age`) VALUES ('3', 'Srikar', 'Srikar', 'x', 'User', 'Reddy', 'Boston', 'Male', 'MA', '26');
INSERT INTO `hw5`.`person` (`person_id`, `first_name`, `user_name`, `password`, `role_name`, `last_name`, `user_city`, `user_gender`, `user_state`, `user_age`) VALUES ('4', 'Ramakanth', 'Ramakanth', 'x', 'User', 'Marri', 'Boston', 'Male', 'MA', '26');

INSERT INTO `hw5`.`phone_type_tb` (`id`, `phone_type_value`) VALUES ('1', 'Mobile');
INSERT INTO `hw5`.`phone_type_tb` (`id`, `phone_type_value`) VALUES ('2', 'Home');
INSERT INTO `hw5`.`phone_type_tb` (`id`) VALUES ('3');
UPDATE `hw5`.`phone_type_tb` SET `phone_type_value`='Work' WHERE `id`='3';


INSERT INTO `hw5`.`phone` (`person_id`, `phone_type_id`, `phone_number`) VALUES ('1', '1', '0123456789');
INSERT INTO `hw5`.`phone` (`person_id`, `phone_type_id`, `phone_number`) VALUES ('2', '1', '1123456789');
INSERT INTO `hw5`.`phone` (`person_id`, `phone_type_id`, `phone_number`) VALUES ('3', '2', '2123456789');
INSERT INTO `hw5`.`phone` (`person_id`, `phone_type_id`, `phone_number`) VALUES ('4', '3', '3123456789');


INSERT INTO `hw5`.`groups` (`group_name`) VALUES ('Sports');
INSERT INTO `hw5`.`groups` (`group_name`) VALUES ('Arts');
INSERT INTO `hw5`.`groups` (`group_name`) VALUES ('Media');
INSERT INTO `hw5`.`groups` (`group_name`) VALUES ('Music');


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

commit;
