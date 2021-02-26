package com.mm.order;

import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.http.HttpServer;

public class OrderVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderVerticle.class);

  @Override
  public void start(Promise<Void> startPromise) {

    HttpServer httpServer = vertx.createHttpServer();

    httpServer.requestHandler(IoC.getInstance().router.configureRouting())
      .rxListen(Properties.getInstance().getPort())
      .subscribe(server -> LOGGER.info(String.format("Server listening on port {%s}", server.actualPort())),
        failure -> LOGGER.error(failure.getMessage()));
  }
}
