
SHOW CREATE TABLE user_account;

/**
##################Point to be noted####################################
if you check the corrosponding entity of user_account we used the 
java.util.Date api to represent the data and dateTime.
But data saved in the user_account is date datatype
adn data savedn in the post is dataTiem data type 

Because we use the @temporal annotation provided by the JAP
**/
CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `subscribed_on` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1

SHOW CREATE TABLE post;

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `published_on` datetime DEFAULT NULL,
  `fk_user_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgs88tcwighdewuxf5oix8se6j` (`fk_user_id`),
  CONSTRAINT `FKgs88tcwighdewuxf5oix8se6j` FOREIGN KEY (`fk_user_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=LATIN1
/*#############################################################################################*/
SELECT * FROM user_account
SELECT * FROM post
SELECT * FROM post_comment

