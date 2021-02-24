package com.mm.catalog.infrastructure.handler;

import com.mm.catalog.IoC;
import com.mm.catalog.infrastructure.handler.resource.PhoneResource;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.reactivex.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CatalogHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatalogHandler.class);

  public void getCatalog(final RoutingContext ctx) {
    IoC.getInstance().service.getAll()
      .map(IoC.getInstance().phoneResourceMapper::toResource)
      .collect((Callable<ArrayList<PhoneResource>>) ArrayList::new, List::add)
      .subscribe(l -> {
        LOGGER.info("Catalog retrieved successfully");
        ctx.response()
          .putHeader("Content-Type", "application/json")
          .end(Json.encodePrettily(l));
      });
  }
}
