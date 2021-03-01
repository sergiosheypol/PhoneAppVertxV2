package com.mm.catalog;

import com.mm.catalog.handler.CatalogHandler;
import com.mm.catalog.mapper.PhoneMapper;
import com.mm.catalog.repository.CatalogRepository;
import com.mm.catalog.repository.dummy.DummyCatalogRepository;
import com.mm.catalog.repository.mongo.MongoCatalogRepository;
import com.mm.catalog.router.CatalogRouter;
import com.mm.catalog.service.CatalogService;
import com.mm.mongo.MongoConfig;
import com.mm.postgres.PostgresConfig;
import com.mm.properties.ConfigProperties;

import static java.util.Objects.isNull;

public final class IoC {
  public CatalogService service;
  public CatalogRepository repository;
  public CatalogHandler handler;
  public CatalogRouter router;
  public PhoneMapper mapper;
  public PostgresConfig postgres;
  public MongoConfig mongo;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if (isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.mongo = new MongoConfig();
    this.postgres = new PostgresConfig();
    this.mapper = new PhoneMapper();
    this.repository = this.injectRepository();
    this.service = new CatalogService(this.repository);
    this.handler = new CatalogHandler(this.service, this.mapper);
    this.router = new CatalogRouter(this.handler);

  }

  private CatalogRepository injectRepository() {
    if (ConfigProperties.isDummyEnabled()) {
      return new DummyCatalogRepository();
    } else {
//      return new PostgresCatalogRepository(this.postgres, this.mapper);
      return new MongoCatalogRepository(this.mongo, this.mapper);
    }
  }
}
