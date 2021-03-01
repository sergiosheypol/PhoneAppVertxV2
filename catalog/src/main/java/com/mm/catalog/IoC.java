package com.mm.catalog;

import com.mm.catalog.repository.dummy.DummyCatalogRepository;
import com.mm.postgres.PostgresConfig;
import com.mm.catalog.handler.CatalogHandler;
import com.mm.catalog.mapper.PhoneResourceMapper;
import com.mm.catalog.repository.CatalogRepository;
import com.mm.catalog.repository.postgres.PostgresCatalogRepository;
import com.mm.catalog.repository.postgres.mapper.PostgresCatalogMapper;
import com.mm.catalog.router.CatalogRouter;
import com.mm.catalog.service.CatalogService;
import com.mm.properties.ConfigProperties;

import static java.util.Objects.isNull;

public final class IoC {
  public CatalogService service;
  public CatalogRepository repository;
  public CatalogHandler handler;
  public CatalogRouter router;
  public PhoneResourceMapper resourceMapper;
  public PostgresConfig postgres;
  public PostgresCatalogMapper repositoryMapper;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if (isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.postgres = new PostgresConfig();
    this.repositoryMapper = new PostgresCatalogMapper();
    this.repository = this.injectRepository();
    this.service = new CatalogService(this.repository);
    this.resourceMapper = new PhoneResourceMapper();
    this.handler = new CatalogHandler(this.service, this.resourceMapper);
    this.router = new CatalogRouter(this.handler);

  }

  private CatalogRepository injectRepository() {
    if (ConfigProperties.isDummyEnabled()) {
      return new DummyCatalogRepository();
    } else {
      return new PostgresCatalogRepository(this.postgres, this.repositoryMapper);
    }
  }
}
