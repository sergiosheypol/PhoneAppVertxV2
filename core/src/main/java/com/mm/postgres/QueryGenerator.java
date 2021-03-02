package com.mm.postgres;

public final class QueryGenerator {

  public static String getAll() {
    return "select catalog.id, catalog.name, catalog.description, catalog.img, catalog.price, currency.name as currencyName from catalog \n" +
      "inner join currency on currency.id = catalog.currencyid";
  }

  public static String save() {
    return "INSERT INTO \"order\" (id, customer_name, customer_surname, customer_email, phone_id)\n" +
      "VALUES(($1), ($2), ($3), ($4), ($5))";
  }
}
