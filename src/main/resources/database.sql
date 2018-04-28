CREATE DATABASE cinema;

CREATE SCHEMA cinema;

CREATE TABLE cinema.users (
  id serial PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  birthday date
);

CREATE TABLE cinema.roles (
  id  serial PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

INSERT INTO cinema.roles VALUES (1, 'ROLE_USER');


CREATE TABLE cinema.user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES cinema.users (id),
  FOREIGN KEY (role_id) REFERENCES cinema.roles (id),

  UNIQUE (user_id, role_id)
);