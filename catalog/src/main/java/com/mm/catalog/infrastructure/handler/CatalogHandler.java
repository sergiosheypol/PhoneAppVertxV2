package com.mm.catalog.infrastructure.handler;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.ext.web.RoutingContext;

public class CatalogHandler {

  public void getCatalog(final RoutingContext ctx) {
    ctx.response()
      .putHeader("Content-Type", "application/json")
      .end(Json.encodePrettily(new JsonObject().put("msg", "hola")));
  }
}
