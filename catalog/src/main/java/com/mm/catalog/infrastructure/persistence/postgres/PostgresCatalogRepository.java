package com.mm.catalog.infrastructure.persistence.postgres;

import com.mm.catalog.IoC;
import com.mm.catalog.domain.model.PhoneModel;
import com.mm.catalog.domain.repository.CatalogRepository;
import com.mm.catalog.infrastructure.persistence.dummy.PhoneData;
import io.reactivex.Flowable;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.pgclient.PgPool;

public class PostgresCatalogRepository implements CatalogRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresCatalogRepository.class);

  private final PgPool pgClient;

  public PostgresCatalogRepository() {
    this.pgClient = IoC.getInstance().pgClient;
  }

  @Override
  public Flowable<PhoneModel> getAll() {

    pgClient
      .query("SELECT * FROM catalog")
      .rxExecute()
      .subscribe(rows -> {
        LOGGER.info("Got " + rows.size() + " rows ");
        // Now close the pool
        pgClient.close();
      }, err -> {
        LOGGER.error("Error while retrieving rows", err);
      });


    return Flowable.just(PhoneData.getSamsung(),
      PhoneData.getIphone(),
      PhoneData.getXiaomi(),
      PhoneData.getHuawei());
  }
}
