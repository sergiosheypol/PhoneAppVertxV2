package com.mm.order.handler;

import com.mm.order.service.OrderService;
import io.vertx.core.json.Json;
import io.vertx.reactivex.ext.web.RoutingContext;

public class OrderHandler {

  private final OrderService service;

  public OrderHandler(final OrderService service) {
    this.service = service;
  }

  public void purchase(final RoutingContext ctx) {
    this.service.purchase()
      .subscribe(order -> ctx.response()
      .putHeader("Content-Type", "application/json")
      .end(Json.encodePrettily(order)));
  }
}
