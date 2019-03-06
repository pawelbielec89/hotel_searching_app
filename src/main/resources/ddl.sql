CREATE TABLE IF NOT EXISTS hotel (
  id SERIAL PRIMARY KEY,
	hotel_name VARCHAR(100),
	city VARCHAR(100),
	adress VARCHAR(100),
	email VARCHAR(100),
	website VARCHAR(100),
	rate INT
);