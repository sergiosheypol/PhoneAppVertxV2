package com.mm.catalog.infrastructure.router;

import com.mm.catalog.IoC;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class CatalogRouter {

  public Router configureRouting(final Vertx vertx) {
    Router router = Router.router(vertx);
    router.get("/catalog").handler(IoC.getInstance().handler::getCatalog);
    return router;
  }
}
