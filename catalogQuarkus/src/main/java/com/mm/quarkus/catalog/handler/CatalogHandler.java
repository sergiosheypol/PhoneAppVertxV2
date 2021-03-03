package com.mm.quarkus.catalog.handler;

import com.mm.quarkus.catalog.handler.resource.PhoneResource;
import com.mm.quarkus.catalog.mapper.PhoneMapper;
import com.mm.quarkus.catalog.service.CatalogService;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@ApplicationScoped
public class CatalogHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatalogHandler.class);

  @Inject
  CatalogService service;

  @Inject
  PhoneMapper mapper;

  public void getCatalog(final RoutingContext ctx) {
    this.service.getAll()
      .map(mapper::toResource)
      .collect((Callable<ArrayList<PhoneResource>>) ArrayList::new, List::add)
      .subscribe(l -> {
        LOGGER.info("Catalog retrieved successfully");
        ctx.response()
          .putHeader("Content-Type", "application/json")
          .end(Json.encodePrettily(l));
      });
  }
}
