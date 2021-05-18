package com.mm.catalog;

import com.mm.properties.ConfigProperties;
import io.reactivex.Completable;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.http.HttpServer;

public class CatalogVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatalogVerticle.class);

  @Override
  @SuppressWarnings("CheckReturnValue")
  public Completable rxStart() {
    HttpServer httpServer = vertx.createHttpServer();

    return httpServer.requestHandler(IoC.getInstance().router.configureRouting())
      .rxListen(ConfigProperties.getPort())
      .doOnSuccess(server -> LOGGER.info(String.format("Server listening on port {%s}", server.actualPort())))
      .ignoreElement();
  }
}
