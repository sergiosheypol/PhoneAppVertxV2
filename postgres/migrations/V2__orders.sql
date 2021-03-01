CREATE TABLE "order" (
  id UUID NOT NULL PRIMARY KEY,
  customer_name VARCHAR(50) NOT NULL,
  customer_surname VARCHAR(50) NOT NULL,
  customer_email VARCHAR(50) NOT NULL,
  phone_id UUID NOT NULL,
  FOREIGN KEY (phone_id) REFERENCES catalog(id)
);


