package com.mm.order.router;

import com.mm.order.handler.OrderHandler;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class OrderRouter {

  private final OrderHandler handler;

  public OrderRouter(OrderHandler handler) {
    this.handler = handler;
  }

  public Router configureRouting() {
    final Router router = Router.router(Vertx.currentContext().owner());
    router.post("/order").handler(handler::purchase);
    return router;
  }


}
