package com.mm.catalog.handler;

import com.mm.catalog.service.CatalogService;
import com.mm.catalog.handler.mapper.PhoneResourceMapper;
import com.mm.catalog.handler.resource.PhoneResource;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.reactivex.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CatalogHandler {

  private final CatalogService service;
  private final PhoneResourceMapper mapper;

  public CatalogHandler(final CatalogService service, final PhoneResourceMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(CatalogHandler.class);

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
