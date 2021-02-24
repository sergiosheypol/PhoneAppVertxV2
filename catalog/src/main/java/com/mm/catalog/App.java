package com.mm.catalog;

import io.vertx.reactivex.core.Vertx;

public class App {
  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new CatalogVerticle());
  }
}
