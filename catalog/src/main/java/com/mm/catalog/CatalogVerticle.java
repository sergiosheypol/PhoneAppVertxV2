package com.mm.catalog;

import com.mm.catalog.infrastructure.router.CatalogRouter;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.http.HttpServer;

public class CatalogVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatalogVerticle.class);

  private final CatalogRouter router;

  public CatalogVerticle() {
    this.router = new CatalogRouter();
  }

  @Override
  public void start(final Promise<Void> startPromise) {

    HttpServer httpServer = vertx.createHttpServer();

    httpServer.requestHandler(this.router.configureRouting(vertx))
      .rxListen(8080)
      .subscribe(server -> LOGGER.info(String.format("Server listening on port %s", server.actualPort())),
        failure -> LOGGER.error(failure.getMessage()));

  }
}
