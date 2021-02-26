package com.mm.catalog.repository.postgres;

public final class QueryGenerator {
  public static String getAll() {
    return "select catalog.id, catalog.name, catalog.description, catalog.img, catalog.price, currency.name as currencyName from catalog \n" +
      "inner join currency on currency.id = catalog.currencyid";
  }
}
