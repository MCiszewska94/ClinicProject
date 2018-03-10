DROP TABLE IF EXISTS doctor;

CREATE TABLE doctor (
  id         INTEGER AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO
  doctor (first_name, last_name)
VALUES
  ('Alison', 'Austin'),
  ('Jim', 'Ward'),
  ('Gary', 'Bowers'),
  ('Tami', 'Burgess'),
  ('Marcus', 'Morton'),
  ('Roman', 'Rogers'),
  ('Wilfred', 'Higgins');