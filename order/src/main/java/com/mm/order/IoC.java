package com.mm.order;

import com.mm.order.handler.OrderHandler;
import com.mm.order.router.OrderRouter;
import com.mm.order.service.OrderService;

import static java.util.Objects.isNull;

public final class IoC {
  public OrderRouter router;
  public OrderHandler handler;
  public OrderService service;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if(isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.service = new OrderService();
    this.handler = new OrderHandler(this.service);
    this.router = new OrderRouter(this.handler);
  }
}
