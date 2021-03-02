CREATE TABLE "currency" (
  id SERIAL NOT NULL PRIMARY KEY,
  name varchar(15) NOT NULL
);

CREATE TABLE "catalog" (
  id UUID NOT NULL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  img VARCHAR(200) NOT NULL,
  description VARCHAR(50) NOT NULL,
  price REAL NOT NULL,
  currencyId INTEGER NOT NULL,
  FOREIGN KEY (currencyId) REFERENCES currency(id)
);

INSERT INTO "currency" ("name") VALUES ('euro');

INSERT INTO "catalog" ("id", "name", "img", "description", "price", "currencyid")
VALUES ('bb4b5d14-7787-11eb-9439-0242ac130002', 'iPhone', 'iphone.png', 'Apple iPhone 12', '999.99', '1');

INSERT INTO "catalog" ("id", "name", "img", "description", "price", "currencyid")
VALUES ('cfd5b224-7788-11eb-9439-0242ac130002', 'S21', 'samsung.png', 'Samsung Galaxy S21', '988.00', '1');

INSERT INTO "catalog" ("id", "name", "img", "description", "price", "currencyid")
VALUES ('d7ee984a-7788-11eb-9439-0242ac130002', 'Mi 8', 'xiaomi.png', 'Xiaomi Mi 8', '189.90', '1');

INSERT INTO "catalog" ("id", "name", "img", "description", "price", "currencyid")
VALUES ('dda85294-7788-11eb-9439-0242ac130002', 'P40', 'huawei.png', 'Xiaomi Mi 8', '279.90', '1');

