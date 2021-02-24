package com.mm.catalog;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.http.HttpServer;
import io.vertx.reactivex.ext.web.Router;

public class CatalogVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatalogVerticle.class);

  @Override
  public void start(final Promise<Void> startPromise) {

    HttpServer httpServer = vertx.createHttpServer();

    Router router = Router.router(vertx);

    router.get("/catalog").handler(ctx -> {
      ctx.response()
        .putHeader("Content-Type", "application/json")
        .end(Json.encodePrettily(new JsonObject().put("msg", "hola")));
    });

    httpServer.requestHandler(router)
      .rxListen(8080)
      .subscribe(server -> LOGGER.info(String.format("Server listening on port %s", server.actualPort())),
        failure -> LOGGER.error(failure.getMessage()));

  }
}
