package com.mm.catalog.router;

import com.mm.catalog.handler.CatalogHandler;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class CatalogRouter {

  private final CatalogHandler handler;

  public CatalogRouter(final CatalogHandler handler) {
    this.handler = handler;
  }

  public Router configureRouting() {
    Router router = Router.router(Vertx.currentContext().owner());
    router.get("/catalog").handler(handler::getCatalog);
    return router;
  }
}
