package com.mm.order.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.order.handler.resource.OrderRQResource;
import com.mm.order.mapper.OrderMapper;
import com.mm.order.service.OrderService;
import io.reactivex.Single;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.ext.web.RoutingContext;

@SuppressWarnings("CheckReturnValue")
public class OrderHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderHandler.class);

  private final OrderService service;
  private final ObjectMapper objectMapper;
  private final OrderMapper mapper;


  public OrderHandler(final OrderService service, final ObjectMapper objectMapper, final OrderMapper mapper) {
    this.service = service;
    this.objectMapper = objectMapper;
    this.mapper = mapper;
  }

  public void purchase(final RoutingContext ctx) {
    Single.fromCallable(ctx::getBodyAsJson)
      .map(JsonObject::getMap)
      .map(m -> objectMapper.convertValue(m, OrderRQResource.class))
      .map(mapper::toModel)
      .flatMap(service::purchase)
      .map(mapper::toResource)
      .subscribe(rs -> ctx.response()
          .putHeader("Content-Type", "application/json")
          .end(Json.encodePrettily(rs)),
        err -> {
          ctx.response().setStatusCode(500).end();
          LOGGER.error(String.format("Error saving order: %s", err.getMessage()), err);
        });
  }
}
