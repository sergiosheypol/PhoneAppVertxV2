package com.mm.order.repository.postgres;

public final class QueryGenerator {

  public static String save() {
    return "INSERT INTO \"order\" (id, customer_name, customer_surname, customer_email, phone_id)\n" +
      "VALUES(($1), ($2), ($3), ($4), ($5))";
  }

}
