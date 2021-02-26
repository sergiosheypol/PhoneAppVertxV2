package com.mm.catalog.repository.postgres;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.repository.CatalogRepository;
import com.mm.catalog.repository.postgres.mapper.PostgresCatalogMapper;
import com.mm.catalog.config.PostgresConfig;
import io.reactivex.Flowable;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.sqlclient.Row;

public class PostgresCatalogRepository implements CatalogRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresCatalogRepository.class);

  private final PostgresConfig postgres;
  private final PostgresCatalogMapper mapper;

  public PostgresCatalogRepository(PostgresConfig postgres, PostgresCatalogMapper mapper) {
    this.postgres = postgres;
    this.mapper = mapper;
  }

  @Override
  public Flowable<PhoneModel> getAll() {
    return this.postgres.getPgClient()
      .query(QueryGenerator.getAll())
      .rxExecute()
      .doOnSuccess(r -> LOGGER.info(String.format("Retrieved {%s} rows from {catalog}", r.size())))
      .flattenAsFlowable(e -> e)
      .map(Row::toJson)
      .map(mapper::toModel);
  }

}