package com.mm.catalog.infrastructure.router;

import com.mm.catalog.infrastructure.handler.CatalogHandler;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class CatalogRouter {

  private final CatalogHandler handler;

  public CatalogRouter() {
    this.handler = new CatalogHandler();
  }

  public Router configureRouting(final Vertx vertx) {
    Router router = Router.router(vertx);
    router.get("/catalog").handler(handler::getCatalog);
    return router;
  }
}
