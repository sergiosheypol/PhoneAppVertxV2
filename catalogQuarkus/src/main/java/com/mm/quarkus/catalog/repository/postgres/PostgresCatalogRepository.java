package com.mm.quarkus.catalog.repository.postgres;

import com.mm.quarkus.catalog.mapper.PhoneMapper;
import com.mm.quarkus.catalog.model.PhoneModel;
import com.mm.quarkus.catalog.repository.CatalogRepository;
import io.quarkus.arc.properties.IfBuildProperty;
import io.reactivex.Flowable;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.converters.multi.MultiRxConverters;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.mutiny.pgclient.PgPool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@IfBuildProperty(name = "repository", stringValue = "postgres")
public class PostgresCatalogRepository implements CatalogRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresCatalogRepository.class);

  @Inject
  PgPool client;

  @Inject
  PhoneMapper mapper;

  @Override
  public Flowable<PhoneModel> getAll() {
    return this.client.query(QueryGenerator.getAll())
      .execute()
      .map(r -> {
        LOGGER.info(String.format("Retrieved {%s} rows from {catalog}", r.size()));
        return r;
      })
      .onItem().transformToMulti(e -> Multi.createFrom().iterable(e))
      .map(mapper::toModel)
      .convert().with(MultiRxConverters.toFlowable());

  }

}
