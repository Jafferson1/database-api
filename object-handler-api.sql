
create database projects_test;
use projects_test;

CREATE TABLE IF NOT EXISTS user (
  id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  username varchar(100) NOT NULL,
  firstname varchar(100) NOT NULL,
  surname varchar(100) NOT NULL,
  email varchar(250) NOT NULL,
  password text NOT NULL,
  phone varchar(100) NOT NULL,
  joined TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;