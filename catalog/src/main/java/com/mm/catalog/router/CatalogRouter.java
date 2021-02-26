package com.mm.catalog.router;

import com.mm.catalog.handler.CatalogHandler;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class CatalogRouter {

  private final CatalogHandler handler;

  public CatalogRouter(CatalogHandler handler) {
    this.handler = handler;
  }

  public Router configureRouting(final Vertx vertx) {
    Router router = Router.router(vertx);
    router.get("/catalog").handler(handler::getCatalog);
    return router;
  }
}
