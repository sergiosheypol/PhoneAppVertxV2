CREATE SCHEMA mm;

CREATE TABLE currency (
  id SERIAL NOT NULL PRIMARY KEY,
  name varchar(15) NOT NULL
);

CREATE TABLE catalog (
  id UUID NOT NULL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  img VARCHAR(50) NOT NULL,
  description VARCHAR(50) NOT NULL,
  price REAL NOT NULL,
  currencyId INTEGER NOT NULL,
  FOREIGN KEY (currencyId) REFERENCES currency(id)
)
