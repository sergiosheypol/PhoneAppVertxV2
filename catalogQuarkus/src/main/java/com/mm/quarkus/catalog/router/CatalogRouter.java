package com.mm.quarkus.catalog.router;

import com.mm.quarkus.catalog.handler.CatalogHandler;
import io.vertx.ext.web.Router;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class CatalogRouter {

  @Inject
  CatalogHandler handler;

  public void init(@Observes Router router) {
    router.get("/catalog").handler(handler::getCatalog);
  }
}
