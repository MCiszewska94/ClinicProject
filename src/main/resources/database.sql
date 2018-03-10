DROP DATABASE IF EXISTS clinic;
CREATE DATABASE clinic;
DROP TABLE doctor;


CREATE TABLE doctor (
  id         INTEGER AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
ALTER TABLE doctor
  AUTO_INCREMENT = 1;


INSERT INTO
  doctor (first_name, last_name)
VALUES
  ('Alison', 'Austin'),
  ('Jim', 'Ward'),
  ('Gary', 'Bowers'),
  ('Tami','Burgess'),
  ('Marcus','Morton'),
  ('Roman','Rogers'),
  ('Wilfred','Higgins');



