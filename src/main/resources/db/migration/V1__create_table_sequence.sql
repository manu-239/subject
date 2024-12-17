CREATE TABLE subject (
  id BIGINT PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE,
  description VARCHAR(250)
);


CREATE TABLE subject_sequence (
  next_val bigint DEFAULT NULL
);

INSERT INTO subject_sequence VALUES (1);