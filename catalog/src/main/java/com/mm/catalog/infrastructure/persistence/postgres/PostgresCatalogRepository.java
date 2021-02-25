package com.mm.catalog.infrastructure.persistence.postgres;

import com.mm.catalog.IoC;
import com.mm.catalog.domain.model.PhoneModel;
import com.mm.catalog.domain.repository.CatalogRepository;
import com.mm.catalog.infrastructure.persistence.dummy.PhoneData;
import io.reactivex.Flowable;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class PostgresCatalogRepository implements CatalogRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresCatalogRepository.class);

  @Override
  public Flowable<PhoneModel> getAll() {
    IoC.getInstance().postgres.getPgClient()
      .query("SELECT * FROM catalog")
      .rxExecute()
      .subscribe(rows -> {
        LOGGER.info("Got " + rows.size() + " rows ");
        // Now close the pool
        IoC.getInstance().postgres.getPgClient().close();
      }, err -> {
        LOGGER.error("Error while retrieving rows", err);
      });


    return Flowable.just(PhoneData.getSamsung(),
      PhoneData.getIphone(),
      PhoneData.getXiaomi(),
      PhoneData.getHuawei());
  }
}
