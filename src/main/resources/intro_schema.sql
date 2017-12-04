DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id             SERIAL NOT NULL PRIMARY KEY,
  first_name     VARCHAR(50),
  last_name      VARCHAR(50)  NOT NULL
);

INSERT INTO customer (first_name,last_name) VALUES 
  ('Carl', 'Daysh'), 
  ('Ashien', 'Wilber'), 
  ('Max', 'Roder'), 
  ('Johnny', 'Drayn'), 
  ('Addy', 'Korda'), 
  ('Sid', 'Darko');
