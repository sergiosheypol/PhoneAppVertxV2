package com.mm.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.order.config.PostgresConfig;
import com.mm.order.handler.OrderHandler;
import com.mm.order.mapper.OrderMapper;
import com.mm.order.repository.OrderRepository;
import com.mm.order.repository.PostgresOrderRepository;
import com.mm.order.router.OrderRouter;
import com.mm.order.service.OrderService;

import static java.util.Objects.isNull;

public final class IoC {
  public OrderRouter router;
  public OrderHandler handler;
  public OrderService service;
  public OrderRepository repository;
  public PostgresConfig postgres;
  public ObjectMapper objectMapper;
  public OrderMapper mapper;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if (isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.mapper = new OrderMapper();
    this.objectMapper = new ObjectMapper();
    this.postgres = new PostgresConfig();
    this.repository = new PostgresOrderRepository(this.postgres);
    this.service = new OrderService(this.repository);
    this.handler = new OrderHandler(this.service, this.objectMapper, this.mapper);
    this.router = new OrderRouter(this.handler);
  }
}
