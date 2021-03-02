package com.mm.order.router;

import com.mm.order.handler.OrderHandler;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.handler.BodyHandler;

public class OrderRouter {

  private final OrderHandler handler;

  public OrderRouter(final OrderHandler handler) {
    this.handler = handler;
  }

  public Router configureRouting() {
    final Router router = Router.router(Vertx.currentContext().owner());
    router.route().handler(BodyHandler.create());
    router.post("/order").consumes("application/json").handler(handler::purchase);
    return router;
  }


}
