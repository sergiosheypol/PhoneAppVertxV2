package com.mm.catalog;

import com.mm.catalog.application.getcatalog.GetCatalogService;
import com.mm.catalog.domain.repository.CatalogRepository;
import com.mm.catalog.infrastructure.handler.CatalogHandler;
import com.mm.catalog.infrastructure.handler.mapper.PhoneResourceMapper;
import com.mm.catalog.infrastructure.persistence.dummy.DummyCatalogRepository;
import com.mm.catalog.infrastructure.persistence.postgres.config.PostgresConfig;
import com.mm.catalog.infrastructure.router.CatalogRouter;
import io.vertx.reactivex.pgclient.PgPool;

import static java.util.Objects.isNull;

public class IoC {
  public GetCatalogService service;
  public CatalogRepository repository;
  public CatalogHandler handler;
  public CatalogRouter router;
  public PhoneResourceMapper phoneResourceMapper;
  public PgPool pgClient;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if(isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.service = new GetCatalogService();
    this.repository = new DummyCatalogRepository();
    this.handler = new CatalogHandler();
    this.router = new CatalogRouter();
    this.phoneResourceMapper = new PhoneResourceMapper();
    this.pgClient = PostgresConfig.init();
  }
}
