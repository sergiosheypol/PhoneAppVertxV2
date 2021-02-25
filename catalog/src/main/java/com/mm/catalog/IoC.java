package com.mm.catalog;

import com.mm.catalog.application.getcatalog.CatalogService;
import com.mm.catalog.domain.repository.CatalogRepository;
import com.mm.catalog.infrastructure.handler.CatalogHandler;
import com.mm.catalog.infrastructure.handler.mapper.PhoneResourceMapper;
import com.mm.catalog.infrastructure.persistence.postgres.mapper.PostgresCatalogMapper;
import com.mm.catalog.infrastructure.persistence.postgres.PostgresCatalogRepository;
import com.mm.catalog.infrastructure.persistence.postgres.config.PostgresConfig;
import com.mm.catalog.infrastructure.router.CatalogRouter;

import static java.util.Objects.isNull;

public class IoC {
  public CatalogService service;
  public CatalogRepository repository;
  public CatalogHandler handler;
  public CatalogRouter router;
  public PhoneResourceMapper resourceMapper;
  public PostgresConfig postgres;
  public PostgresCatalogMapper repositoryMapper;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if(isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.postgres = new PostgresConfig();
    this.repositoryMapper = new PostgresCatalogMapper();
    this.repository = new PostgresCatalogRepository(this.postgres, this.repositoryMapper);
    this.service = new CatalogService(this.repository);
    this.resourceMapper = new PhoneResourceMapper();
    this.handler = new CatalogHandler(this.service, this.resourceMapper);
    this.router = new CatalogRouter(this.handler);

  }
}
