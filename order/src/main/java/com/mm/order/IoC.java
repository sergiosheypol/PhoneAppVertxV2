package com.mm.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.mongo.MongoConfig;
import com.mm.order.handler.OrderHandler;
import com.mm.order.mapper.OrderMapper;
import com.mm.order.repository.OrderRepository;
import com.mm.order.repository.mongo.MongoOrderRepository;
import com.mm.order.repository.postgres.PostgresOrderRepository;
import com.mm.order.router.OrderRouter;
import com.mm.order.service.OrderService;
import com.mm.postgres.PostgresConfig;
import com.mm.properties.ConfigProperties;

import static java.util.Objects.isNull;

public final class IoC {
  public OrderRouter router;
  public OrderHandler handler;
  public OrderService service;
  public OrderRepository repository;
  public PostgresConfig postgres;
  public ObjectMapper objectMapper;
  public OrderMapper mapper;
  public MongoConfig mongo;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if (isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.mongo = new MongoConfig();
    this.mapper = new OrderMapper();
    this.objectMapper = new ObjectMapper();
    this.postgres = new PostgresConfig();
    this.repository = new PostgresOrderRepository(this.postgres);
    this.service = new OrderService(this.repository);
    this.handler = new OrderHandler(this.service, this.objectMapper, this.mapper);
    this.router = new OrderRouter(this.handler);
  }

  private OrderRepository injectRepository() {
    switch (ConfigProperties.getRepositoryName()) {
      case "mongo":
        return new MongoOrderRepository(this.mongo);
      default:
        return new PostgresOrderRepository(this.postgres);
    }
  }
}
